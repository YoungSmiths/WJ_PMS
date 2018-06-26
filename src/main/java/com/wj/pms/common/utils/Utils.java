package com.wj.pms.common.utils;

import com.wj.pms.common.model.BaseEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;
import io.netty.buffer.ByteBuf;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

/**
 * Created by YoungSmith on 2018/2/17.
 */
public class Utils {
    private static final ObjectMapper mapper = new ObjectMapper();
    /**
     * 上传文件
     *
     * @param path 文件所在目录
     * @param file 文件
     */
    public static void uploadFile(String path, MultipartFile file) throws Exception {
        try {
            File catalog = new File(path);
            if (!catalog.exists() && !catalog.isDirectory()) {
                catalog.mkdirs();
            }
            String filePath = path + file.getOriginalFilename();
            File fi = new File(filePath);
            if (!fi.exists()) {
                fi.createNewFile();
            }
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(fi));
            out.write(file.getBytes());
            out.flush();
            out.close();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public static void deleteFile(String path) {
        File file = new File(path);
        file.delete();
    }

    /**
     * 上传文件到Linux
     *
     * @param directory 上传的目录
     * @param uploadFile 要上传的文件
     * @param sftp
     */
    public static void upload(String path, String uploadFile, ChannelSftp sftp) {
        try {
            sftp.cd(path);
            File file = new File(uploadFile);
            sftp.put(new FileInputStream(file), file.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 下载文件
     *
     * @param directory 下载目录
     * @param downloadFile 下载的文件
     * @param saveFile 存在本地的路径
     * @param sftp
     */
    public static void download(String directory, String downloadFile, String saveFile, ChannelSftp sftp) {
        try {
            sftp.cd(directory);
            File file = new File(saveFile);
            sftp.get(downloadFile, new FileOutputStream(file));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除文件
     *
     * @param directory 要删除文件所在目录
     * @param deleteFile 要删除的文件
     * @param sftp
     */
    public static void delete(String directory, String deleteFile, ChannelSftp sftp) {
        try {
            sftp.cd(directory);
            sftp.rm(deleteFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 列出目录下的文件
     *
     * @return
     * @param directory 要列出的目录
     * @param sftp
     * @throws SftpException
     */
    @SuppressWarnings("unchecked")
    public static Vector<ChannelSftp.LsEntry> listFiles(String directory, ChannelSftp sftp) throws SftpException {
        return sftp.ls(directory);
    }

    public static String exec(String cmd, Session session) throws Exception {
        ChannelExec channelExec = null;
        try {
            channelExec = (ChannelExec) session.openChannel("exec");
            channelExec.setCommand(cmd);
            channelExec.setInputStream(null);
            channelExec.setErrStream(null);
            InputStream in = channelExec.getInputStream();
            channelExec.connect();
            StringBuilder buf = new StringBuilder(1024);
            byte[] tmp = new byte[1024];
            while (true) {
                while (in.available() > 0) {
                    int i = in.read(tmp, 0, 1024);
                    if (i < 0)
                        break;
                    buf.append(new String(tmp, 0, i));
                }
                if (channelExec.isClosed()) {
                    break;
                }
                Thread.sleep(1000);
                break;
            }
            in.close();
            return buf.toString();
        } catch (Exception e) {
            String message = "Failed to execute commands use jsch exec";
            throw new Exception(message, e);
        } finally {
            if (channelExec != null) {
                channelExec.disconnect();
            }
        }
    }

    /**
     * 判断操作系统是否是Windows
     *
     * @return
     */
    public static boolean isWindowsOS() {
        boolean isWindowsOS = false;
        String osName = System.getProperty("os.name");
        if (osName.toLowerCase().indexOf("windows") > -1) {
            isWindowsOS = true;
        }
        return isWindowsOS;
    }

    public static String getLinuxLocalIp() throws SocketException {
        String ip = "";
        for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements(); ) {
            NetworkInterface intf = en.nextElement();
            String name = intf.getName();
            if (!name.contains("docker") && !name.contains("lo")) {
                for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress()) {
                        String ipaddress = inetAddress.getHostAddress().toString();
                        if (!ipaddress.contains("::") && !ipaddress.contains("0:0:") && !ipaddress.contains("fe80")) {
                            ip = ipaddress;
                        }
                    }
                }
            }
        }
        return ip;
    }

    public static void sleepForTime(long time) {
        try {
            Thread.currentThread().sleep(time);
        } catch (InterruptedException e) {
            // Ignore it.
        }
    }

    public static byte[] readByteBuf(ByteBuf byteBuf) {
        byte[] result = new byte[byteBuf.readableBytes()];
        byteBuf.readBytes(result);
        return result;
    }

    public static String formatObjectToJson(Object input) {
        try {
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(input);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Serialize object to json failed.");
        }
    }

    public static <T extends BaseEntity> ObjectNode valueToTree(T object) {
        return mapper.valueToTree(object);
    }

    public static <T extends BaseEntity> ArrayNode valueToTree(List<T> object) {
        return mapper.valueToTree(object);
    }
}

