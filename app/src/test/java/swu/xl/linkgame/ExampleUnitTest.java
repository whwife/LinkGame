package swu.xl.linkgame;

import org.junit.Test;

import java.util.List;

import swu.xl.linkgame.Constant.Enum.LevelMode;
import swu.xl.linkgame.LinkGame.Model.AnimalPoint;
import swu.xl.linkgame.LinkGame.Utils.AnimalSearchUtil;
import swu.xl.linkgame.LinkGame.Constant.LinkConstant;
import swu.xl.linkgame.LinkGame.Model.LinkInfo;
import swu.xl.linkgame.LinkGame.Utils.LinkUtil;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    //测试枚举的值
    @Test
    public void enumValueTest(){
        assertEquals(1, LevelMode.LEVEL_MODE_EASY.getValue());
    }

    /**
     * 测试模板1
     * 0,0,0,0,0,0
     * 0,1,2,3,4,0
     * 0,2,4,1,4,0
     * 0,3,1,3,2,0
     * 0,1,4,2,3,0
     * 0,0,0,0,0,0
     *
     * 测试模板1
     * 0,0,0,0,0,0
     * 0,1,0,3,4,0
     * 0,2,0,1,4,0
     * 0,3,1,3,2,0
     * 0,1,5,2,3,0
     * 0,0,0,0,0,0
     */

    //两个转折点：测试连连看(1,1),(4,1)两点是否可以相连的逻辑实现
    @Test
    public void canMatchTwo(){
        LinkInfo linkInfo = new LinkInfo();

        assertTrue(AnimalSearchUtil.canMatchTwoAnimalWithTwoBreak(
                LinkConstant.board_test1,
                new AnimalPoint(1, 1),
                new AnimalPoint(4, 1),
                linkInfo
        ));
    }

    //两个转折点：测试连连看(1,1),(4,1)两点相连的点信息
    @Test
    public void matchTwoLinkInfo(){
        LinkInfo linkInfo = new LinkInfo();

        AnimalSearchUtil.canMatchTwoAnimalWithTwoBreak(
                LinkConstant.board_test1,
                new AnimalPoint(1, 1),
                new AnimalPoint(4, 1),
                linkInfo
        );

        assertEquals(4,linkInfo.getPoints().size());
    }

    //一个转折点：测试连连看(2,3),(3,2)两点是否可以相连的逻辑实现
    @Test
    public void canMatchOne(){
        LinkInfo linkInfo = new LinkInfo();

        assertTrue(AnimalSearchUtil.canMatchTwoAnimalWithTwoBreak(
                LinkConstant.board_test2,
                new AnimalPoint(2, 3),
                new AnimalPoint(3, 2),
                linkInfo
        ));
    }

    //一个转折点:测试连连看(2,3),(3,2)两点相连的点信息
    @Test
    public void matchOneLinkInfo(){
        LinkInfo linkInfo = new LinkInfo();

        AnimalSearchUtil.canMatchTwoAnimalWithTwoBreak(
                LinkConstant.board_test2,
                new AnimalPoint(2, 3),
                new AnimalPoint(3, 2),
                linkInfo
        );

        assertEquals(3,linkInfo.getPoints().size());
    }

    //无转折点：测试连连看(1,4),(2,4)两点是否可以相连的逻辑实现
    @Test
    public void canMatchNo(){
        LinkInfo linkInfo = new LinkInfo();

        assertTrue(AnimalSearchUtil.canMatchTwoAnimalWithTwoBreak(
                LinkConstant.board_test1,
                new AnimalPoint(1, 4),
                new AnimalPoint(2, 4),
                linkInfo
        ));
    }

    //无转折点：测试连连看(1,4),(2,4)两点相连的点信息
    @Test
    public void matchNoLinkInfo(){
        LinkInfo linkInfo = new LinkInfo();

        AnimalSearchUtil.canMatchTwoAnimalWithTwoBreak(
                LinkConstant.board_test1,
                new AnimalPoint(1, 4),
                new AnimalPoint(2, 4),
                linkInfo
        );

        assertEquals(2,linkInfo.getPoints().size());
    }

    //测试二维矩阵最大值的求解
    @Test
    public void maxData_Test1(){
        int maxData = LinkUtil.getMaxData(LinkConstant.board_test1);

        assertEquals(4,maxData);
    }

    //测试二维矩阵最大值的求解
    @Test
    public void maxData_Test2(){
        int maxData = LinkUtil.getMaxData(LinkConstant.board_test2);

        assertEquals(5,maxData);
    }

    //测试加载的图片是否随机
    @Test
    public void randomResource(){
        List<Integer> lists = LinkUtil.loadPictureResourceWithBoard(LinkConstant.board_test1);

        for (int i = 0; i < lists.size(); i++) {
            System.out.println(lists.get(i));
        }

        assertEquals(4,lists.size());
    }

    //追加测试
    //一个转折点:测试连连看(1,3),(3,1)两点相连的点信息
    @Test
    public void matchOneLinkInfo_Add(){
        LinkInfo linkInfo = new LinkInfo();

        AnimalSearchUtil.canMatchTwoAnimalWithTwoBreak(
                LinkConstant.board_test3,
                new AnimalPoint(1, 3),
                new AnimalPoint(3, 1),
                linkInfo
        );

        assertEquals(3,linkInfo.getPoints().size());
    }

    //无转折点：测试连连看(1,3),(3,1)两点是否可以相连的逻辑实现
    @Test
    public void canMatchNo_Add(){
        LinkInfo linkInfo = new LinkInfo();

        assertTrue(AnimalSearchUtil.canMatchTwoAnimalWithTwoBreak(
                LinkConstant.board_test3,
                new AnimalPoint(1, 3),
                new AnimalPoint(3, 1),
                linkInfo
        ));
    }

    //测试角度
    @Test
    public void getDegreeByTan(){
        double v1 = Math.toDegrees(Math.atan(Math.sqrt(44) / 10));
        System.out.println(v1);

        double v2 = Math.toDegrees(Math.atan(Math.sqrt(95) / 10));
        System.out.println(v2);
    }
}
