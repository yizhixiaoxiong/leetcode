package leetcode.a921to930;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description : 独特的电子邮件地址
 * <p>
 * 给定一个电子邮件地址列表，判断里面有几个有效的地址
 * 在 alice@leetcode.com中， alice 是本地名称，而 leetcode.com 是域名。
 * <p>
 * 条件如下： 1.本地名称中有"."则忽略，有"+"去掉第一个"+"后面的串
 * 2. 域名 不受控制
 * @demand :
 * @Auther : hanxiaofan
 * @Date : 2019/7/8 21:37
 * @Product_Name : leetcode
 */
public class NumUniqueEmails929 {

    public static void main(String[] args) {
        String[] emails = {"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com",
                "testemail+david@lee.tcode.com"};

        System.out.println(numUniqueEmails(emails));
    }

    //以@划分为两个部分
    public static int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < emails.length; i++) {
            StringBuilder sb = new StringBuilder();
            String[] splits = emails[i].split("@");
            //先找到'+'
            int index = splits[0].indexOf('+');
            if (index != -1) {
                splits[0] = splits[0].substring(0, index);
            }
            char[] chars = splits[0].toCharArray();
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] != '.') {
                    sb.append(chars[j]);
                }
            }
            sb.append("@" + splits[1]);
            set.add(sb.toString());
        }
        return set.size();
    }
}
