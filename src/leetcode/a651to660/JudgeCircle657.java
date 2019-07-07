package leetcode.a651to660;

/**
 * @Description : 机器人能否返回原点
 * <p>
 * 机器人的有效动作有 R（右），L（左），U（上）和 D（下）。
 * 字符 move[i] 表示其第 i 次移动
 * 如果机器人在完成所有动作后返回原点，
 * 则返回 true。否则，返回 false。
 * <p>
 * 例子1：
 * 输入: "UD"
 * 输出: true
 * 解释：机器人向上移动一次，然后向下移动一次。
 * 所有动作都具有相同的幅度，因此它最终回到它开始的原点。
 * 因此，我们返回 true。
 * <p>
 * 例子2：
 * 输入: "LL"
 * 输出: false
 * 解释：机器人向左移动两次。它最终位于原点的左侧，
 * 距原点有两次 “移动” 的距离。我们返回 false，
 * 因为它在移动结束时没有返回原点。
 * @demand :
 * @Auther : hanxiaofan
 * @Date : 2019/7/5 19:34
 * @Product_Name : leetcode
 */
public class JudgeCircle657 {

    public static void main(String[] args) {
        String moves = "LL";
        System.out.println(judgeCircle(moves));
    }


    //字符串中的字符只有'R','L''U','D'四种
    //所以只要'R'=='L' 'U' == 'D' 即是原点
    public static boolean judgeCircle(String moves) {
        int x = 0;      //水平
        int y = 0;      //竖直
        for (int i = 0; i < moves.length(); i++) {
            if (moves.charAt(i) == 'R'){
                x++;
            }else if(moves.charAt(i) == 'L'){
                x--;
            }else if(moves.charAt(i) == 'U'){
                y++;
            }else if(moves.charAt(i) == 'D'){
                y--;
            }
        }
        if (x != 0 || y != 0){
            return false;
        }
        return true;
    }

}
