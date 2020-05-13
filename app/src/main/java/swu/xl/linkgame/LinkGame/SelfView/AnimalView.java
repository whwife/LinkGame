package swu.xl.linkgame.LinkGame.SelfView;

import android.content.Context;

import swu.xl.linkgame.LinkGame.Model.AnimalPoint;
import swu.xl.linkgame.LinkGame.Constant.LinkConstant;

public class AnimalView extends androidx.appcompat.widget.AppCompatImageView {
    //图片的标志代号，用来判断两个图片是否相等
    private int flag;

    //图片的坐标
    private AnimalPoint point;

    /**
     * 构造方法
     * @param context
     */
    public AnimalView(Context context, int flag, AnimalPoint point) {
        super(context);
        this.flag = flag;
        this.point = point;
    }
    public AnimalView(Context context, int resource_src, int flag, AnimalPoint point) {
        super(context);

        //设置背景颜色
        this.setBackgroundResource(LinkConstant.ANIMAL_BG);
        //设置显示的图片
        this.setImageResource(resource_src);

        //保存标志
        this.flag = flag;

        //保存坐标
        this.point = point;
    }

    //选中时的背景
    public void changeAnimalBackground(int resource){
        this.setBackgroundResource(resource);
    }

    //setter,getter
    public int getFlag() {
        return flag;
    }

    public AnimalPoint getPoint() {
        return point;
    }

    @Override
    public String toString() {
        return "AnimalView{" +
                "flag=" + flag +
                ", point=" + point +
                '}';
    }
}
