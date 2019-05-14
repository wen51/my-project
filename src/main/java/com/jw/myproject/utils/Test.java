package com.jw.myproject.utils;

import org.codehaus.xfire.client.Client;

import java.net.URL;

public class Test {

    public static void main(String[] args) {
        try {
            Client client = new Client(new URL("http://localhost:8080/shengwei/webservice/SyncDeptUserWebService?wsdl"));
            Object[] results = client.invoke("CA_UpdateForSame", new Object[] {xmlString, "asdfasdfa"});
            System.out.println(results[0]);
        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    //    //新增用户
    //    private static String xmlString = "<task>\n" +
    //            "    <user>\n" +
    //            "        <oper>add</oper>\n" +
    //            "        <id>20000001@gd.zg</id>\n" +
    //            "        <name>安全保密管理员</name>\n" +
    //            "        <did>10000001@gd.zg</did>\n" +
    //            "        <dorder>1</dorder>\n" +
    //            "        <dname>中共广东省委</dname>\n" +
    //            "        <sexual>1</sexual>\n" +
    //            "        <duty>管理员 秘书长 科长 秘书长</duty>\n" +
    //            "        <post>11111</post>\n" +
    //            "        <usertype>UT01</usertype>\n" +
    //            "        <grade>内部</grade>\n" +
    //            "        <exts>\n" +
    //            "            <ext>\n" +
    //            "                <did>10000099@gd.zg</did>\n" +
    //            "                <dorder>6</dorder>\n" +
    //            "
    // <dname>OU=维护组,OU=省委办公厅,OU=广东省委,OU=广东省,OU=组织机构,OU=广东省资源管理系统,DC=gd,DC=zg</dname>\n" +
    //            "                <duty>测试人员</duty>\n" +
    //            "                <grade>内部</grade>\n" +
    //            "            </ext>\n" +
    //            "        </exts>\n" +
    //            "    </user>\n" +
    //            "</task>";

    //    // 修改用户
    //    private static String xmlString =
    //            "<task>\n"
    //                    + "\t<user>\n"
    //                    + "\t\t<oper>mod</oper>\n"
    //                    + "\t\t<!--操作类型（修改用户）-->\n"
    //                    + "\t\t<id>14000001@gd.zg</id>\n"
    //                    + "\t\t<!--用户信任号-->\n"
    //                    + "\t\t<name>张三</name>\n"
    //                    + "\t\t<!--用户姓名-->\n"
    //                    + "\t\t<usertype/>\n"
    //                    + "\t\t<!--用户类型UT01：个人证书用户，UT02：法人证书用户-->\n"
    //                    + "\t\t<dname>会议处</dname>\n"
    //                    + "\t\t<!--用户所属机构名称-->\n"
    //                    + "\t\t<did>34000001@gd.zg</did>\n"
    //                    + "\t\t<!--用户所属机构标识-->\n"
    //                    + "\t\t<dorder/>\n"
    //                    + "\t\t<!--用户排序号-->\n"
    //                    + "\t\t<dcode/>\n"
    //                    + "\t\t<!--用户所属机构编码-->\n"
    //                    + "\t\t<sexual>1</sexual>\n"
    //                    + "\t\t<!--用户性别1:男，0：女-->\n"
    //                    + "\t\t<duty/>\n"
    //                    + "\t\t<!--用户职务-->\n"
    //                    + "\t\t<post/>\n"
    //                    + "\t\t<!--用户岗位-->\n"
    //                    + "\t\t<account/>\n"
    //                    + "\t\t<!--用户账号-->\n"
    //                    + "\t\t<password/>\n"
    //                    + "\t\t<!--用户密码-->\n"
    //                    + "\t\t<mail/>\n"
    //                    + "\t\t<!--安全邮箱-->\n"
    //                    + "\t</user>\n"
    //                    + "</task>\n";

    //     取消用户授权
    //    private static String xmlString =
    //            "<task>\n"
    //                    + "\t<user>\n"
    //                    + "\t\t<oper>del</oper>\n"
    //                    + "\t\t<!--操作类型（取消用户授权）-->\n"
    //                    + "\t\t<id>14000001@gd.zg</id>\n"
    //                    + "\t\t<!--用户信任号-->\n"
    //                    + "\t</user>\n"
    //                    + "</task>\n";

    //    // 删除用户
    //    private static String xmlString ="<task>\n" +
    //            "\t<user>\n" +
    //            "\t\t<oper>deluser</oper>\n" +
    //            "\t\t<!--操作类型（删除用户）-->\n" +
    //            "\t\t<id>14000001@gd.zg</id>\n" +
    //            "\t\t<!--用户信任号-->\n" +
    //            "\t</user>\n" +
    //            "</task>\n";

    //    // 新增机构
        private static String xmlString =
                "<task>\n"
                        + "    <org>\n"
                        + "        <oper>add</oper>\n"
                        + "        <!--操作类型：增加机构-->\n"
                        + "        <name>警务室</name>\n"
                        + "        <!--机构名称-->\n"
                        + "        <id>34000002@gd.zg</id>\n"
                        + "        <!--机构唯一标识-->\n"
                        + "        <pid>34000001@gd.zg</pid>\n"
                        + "        <!--上级机构唯一标识-->\n"
                        + "        <order>10002</order>\n"
                        + "        <!--机构排序号-->\n"
                        + "        <standardcode>10010112</standardcode>\n"
                        + "        <!--机构规范编码-->\n"
                        + "        <standardname>办文处标准名称</standardname>\n"
                        + "        <!--机构规范名称-->\n"
                        + "    </org>\n"
                        + "</task>\n";

//    // 修改机构
//    private static String xmlString =
//            "<task>\n"
//                    + "\t<org>\n"
//                    + "\t\t<oper>mod</oper>\n"
//                    + "\t\t<!--操作类型：修改机构-->\n"
//                    + "\t\t<name>办文处</name>\n"
//                    + "\t\t<!--机构名称-->\n"
//                    + "\t\t<id>34000001@gd.zg </id>\n"
//                    + "\t\t<!--机构唯一标识-->\n"
//                    + "\t\t<pid>32000001@gd.zg </pid>\n"
//                    + "\t\t<!--上级机构唯一标识-->\n"
//                    + "\t\t<order>10002</order>\n"
//                    + "\t\t<!--机构排序号-->\n"
//                    + "\t\t<standardcode>100101</standardcode>\n"
//                    + "\t\t<!--机构规范编码-->\n"
//                    + "\t\t<standardname>办文处</standardname>\n"
//                    + "\t\t<!--机构规范名称-->\n"
//                    + "\t</org>\n"
//                    + "</task>\n";

//    // 删除机构
//    private static String xmlString ="<task>\n" +
//            "\t<org>\n" +
//            "\t\t<oper>del</oper>\n" +
//            "\t\t<!--操作类型：删除机构-->\n" +
//            "\t\t<id>34000001@gd.zg </id>\n" +
//            "\t\t<!--机构唯一标识-->\n" +
//            "\t\t<pid>32000001@gd.zg </pid>\n" +
//            "\t\t<!--上级机构唯一标识-->\n" +
//            "\t</org>\n" +
//            "</task>\n";
}
