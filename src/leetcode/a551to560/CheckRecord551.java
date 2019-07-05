package leetcode.a551to560;

/**
 * @Description :学生出勤记录 I
 * <p>
 * 给定一个字符串来代表一个学生的出勤记录，
 * 这个记录仅包含以下三个字符
 * <p>
 * 'A' : Absent，缺勤
 * 'L' : Late，迟到
 * 'P' : Present，到场
 * </p>
 * 如果一个学生的出勤记录中不超过一个'A'(缺勤)
 * 并且不超过两个连续的'L'(迟到),那么这个学生会被奖赏。
 * <p>
 * @demand :
 * @Auther : hanxiaofan
 * @Date : 2019/7/5 12:49
 * @Product_Name : leetcode
 */
public class CheckRecord551 {

    public static void main(String[] args) {
        String s = "PPALLPPLL";
        System.out.println(checkRecord(s));
    }

    //1.不超过一个'A'
    //2.不超过连续的'L'
    public static boolean checkRecord(String s) {
        int countA = 0;  //统计'A'的个数
        int index = 0;  //记录'L'的下标
        int countL =0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                countA++;
                if (countA >= 2) {
                    return false;
                }
            }else if (s.charAt(i) == 'L') {
                //说明是下一个也是
                if (i - index == 1) {
                    index = i;
                    countL++;
                    if (countL == 3){
                        return false;
                    }
                } else {
                    index = i;
                    countL = 1;
                }
            }
        }
        return true;
    }
}
