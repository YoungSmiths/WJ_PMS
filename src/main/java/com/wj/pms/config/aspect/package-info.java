/** Spring AOP 相关代码<br/>
 * 基本分为两大模块：<br/>
 * <PRE>一、AOP日志管理</PRE>
 *    日志管理：具体可在LogInterceptor定制在哪些类的哪些方法进行AOP拦截， 打印拦截方法的的所有参数。<br/>
 *    NonAopLog注解可以指定哪些方法不进行AOP日志打印<br/>
 * <pre>二、AOP参数校验</pre>
 *    参数校验：详情参考ParamNullChecker注解<br/><br/>
 * @author YoungSmith
 * @date 2018年7月31日 下午6:51:37
 */
package com.wj.pms.config.aspect;