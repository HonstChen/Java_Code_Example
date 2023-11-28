package com.ithema.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener, ActionListener {
    int[][] data = new int[4][4];
    int x = 0, y = 0;
    private int step = 0;
    //创建选项下面的条目对象
    JMenuItem replayItem = new JMenuItem("重新游戏");
    JMenuItem reloginItem = new JMenuItem("重新登录");
    JMenuItem closeItem = new JMenuItem("关闭游戏");
    JMenuItem beautyItem = new JMenuItem("美女");
    JMenuItem animalItem = new JMenuItem("动物");
    JMenuItem sportItem = new JMenuItem("运动");
    JMenuItem accountItem = new JMenuItem("公众号");
    String path = "D:\\Java_Code\\untitled\\src\\image\\animal\\animal3\\";
    int[][] win = new int[][]{
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 0}
    };

    public GameJFrame() {
        initJFrame();
        //初始化菜单
        //创建整个的菜单对象
        initJMenuBar();
        //初始化数据，打乱
        initData();
        //初始化图片
        //添加图片的时候，就需要按照二维数组中
        initImage();
        //给整个界面显示出来，建议写在最后
        this.setVisible(true);

    }

    private void initData() {
        int[] tempArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        //打乱数组中的每个元素
        //遍历数组，得到每一个元素，拿着每一个元素与随机索引上的数据进行交换
        Random r = new Random();
        for (int i = 0; i < tempArr.length; i++) {
            int index = r.nextInt(tempArr.length);
            int temp = tempArr[i];
            tempArr[i] = tempArr[index];
            tempArr[index] = temp;
        }
        //给二维数组添加数据
        for (int i = 0; i < tempArr.length; i++) {
            if (tempArr[i] == 0) {
                x = i / 4;
                y = i % 4;
            }
            data[i / 4][i % 4] = tempArr[i];
        }
    }

    private void initImage() {
        //清空已经出现的所有图片
        this.getContentPane().removeAll();


        if (victory()) {
            //显示胜利的图标
            JLabel winJLable = new JLabel(new ImageIcon("D:\\Java_Code\\untitled\\src\\image\\win.png"));
            winJLable.setBounds(203, 283, 197, 73);
            this.getContentPane().add(winJLable);
        }

        JLabel stepCount = new JLabel("步数" + step);
        stepCount.setBounds(50, 30, 100, 20);
        this.getContentPane().add(stepCount);
        /*//创建一个图片ImageIcon的对象
        ImageIcon icon = new ImageIcon("D:\\Java_Code\\untitled\\src\\image\\animal\\animal3\\1.jpg");
        //创建一个JLabel的对象（管理容器）
        JLabel jLabel = new JLabel(icon);
        //指定图片的位置
        jLabel.setBounds(0, 0, 105, 105);
        //把管理容器添加到界面当中
        //this.add(jLabel);
        this.getContentPane().add(jLabel);*/
        for (int i = 0; i < 4; i++) {
            for (int i1 = 0; i1 < 4; i1++) {
                int number = data[i][i1];
                ImageIcon icon = new ImageIcon(path + number + ".jpg");
                //创建一个JLabel的对象（管理容器）
                JLabel jLabel = new JLabel(icon);
                //指定图片的位置
                jLabel.setBounds(105 * i1 + 83, 105 * i + 134, 105, 105);
                //把管理容器添加到界面当中
                //给图片添加边框
                jLabel.setBorder(new BevelBorder(BevelBorder.LOWERED));
                //this.add(jLabel);
                this.getContentPane().add(jLabel);
            }
        }
        JLabel background = new JLabel(new ImageIcon("D:\\Java_Code\\untitled\\src\\image\\login\\background.png"));
        background.setBounds(40, 40, 508, 560);
        //把背景图片添加到界面当中
        this.getContentPane().add(background);

        //刷新一下界面
        this.getContentPane().repaint();
    }

    private void initJMenuBar() {
        JMenuBar jMenuBar = new JMenuBar();

        //创建菜单上面的两个选项的对象（功能关于我们）
        JMenu functionJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("关于我们");
        JMenu changePictureMenu = new JMenu("更换图片");

        functionJMenu.add(changePictureMenu);
        //创建条目

        changePictureMenu.add(beautyItem);
        changePictureMenu.add(animalItem);
        changePictureMenu.add(sportItem);

        //将每一个选项下面的条目添加到选项当中
        functionJMenu.add(replayItem);
        functionJMenu.add(reloginItem);
        functionJMenu.add(closeItem);

        //给条目绑定事件
        replayItem.addActionListener(this);
        reloginItem.addActionListener(this);
        closeItem.addActionListener(this);
        accountItem.addActionListener(this);
        beautyItem.addActionListener(this);
        animalItem.addActionListener(this);
        sportItem.addActionListener(this);

        aboutJMenu.add(accountItem);
        //将菜单里面的两个选项添加到菜单当中
        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutJMenu);

        //给界面设置菜单
        this.setJMenuBar(jMenuBar);
    }

    private void initJFrame() {
        //设置界面的宽高
        this.setSize(603, 680);
        //设置界面的标题
        this.setTitle("拼图单机版1.0");
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //取消默认的居中放置，只有取消了才会按照自己的方式放置图片
        this.setLayout(null);

        //给整个界面添加键盘监听事件
        this.addKeyListener(this);

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == 65) {
            //把界面中的所有图片全部删除
            this.getContentPane().removeAll();
            //加载两张图片
            JLabel all = new JLabel(new ImageIcon(path + "all.jpg"));
            all.setBounds(83, 134, 420, 420);
            this.getContentPane().add(all);
            //加载背景图片

            JLabel background = new JLabel(new ImageIcon("D:\\Java_Code\\untitled\\src\\image\\login\\background.png"));
            background.setBounds(40, 40, 508, 560);
            //把背景图片添加到界面当中
            this.getContentPane().add(background);
            //刷新界面
            this.getContentPane().repaint();

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //判断游戏是否胜利，如果胜利，此方法需要直接结束，不能再执行下面的移动代码了
        if (victory()) {
            //结束方法
            return;
        }
        //对上下左右进行判断
        //左：37 上：38 右：39 下：40
        int code = e.getKeyCode();
        if (code == 37) {
            if (y - 1 >= 0) {
                data[x][y] = data[x][y - 1];
                data[x][--y] = 0;
                step++;
                initImage();
                System.out.println("向左移动");
            }
        } else if (code == 38) {
            //空白方块的数字往上移动
            //x+1,y表示空白方块下方的数字
            if (x - 1 >= 0) {
                data[x][y] = data[x - 1][y];
                data[--x][y] = 0;
                step++;
                initImage();
                System.out.println("向上移动");
            }
        } else if (code == 39) {
            if (y + 1 < 4) {
                data[x][y] = data[x][y + 1];
                data[x][++y] = 0;
                step++;
                initImage();
                System.out.println("像右移动");
            }
        } else if (code == 40) {
            if (x + 1 < 4) {
                data[x][y] = data[x + 1][y];
                data[++x][y] = 0;
                step++;
                initImage();
                System.out.println("向下移动");
            }
        } else if (code == 65) {
            initImage();
        } else if (code == 87) {
            data = new int[][]{
                    {1, 2, 3, 4},
                    {5, 6, 7, 8},
                    {9, 10, 11, 12},
                    {13, 14, 15, 0}
            };
            initImage();
        }
    }

    private boolean victory() {
        //判断1data数组中的数据是否与win的数组中相同
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] != win[i][j])
                    return false;
            }
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == replayItem) {
            System.out.println("重新游戏");
            //再次打乱二维数组的数据
            initData();
            //计步器清零
            step = 0;
            //重新加载图片
            initImage();

        } else if (obj == reloginItem) {
            System.out.println("重新登录");
            //关闭当前界面
            this.setVisible(false);
            //打开登录界面
            new LoginJFrame();
        } else if (obj == closeItem) {
            System.out.println("关闭游戏");
            System.exit(0);
        } else if (obj == accountItem) {
            System.out.println("公众号");
            //创建一个弹框对象
            JDialog jDialog = new JDialog();
            //创建一个管理图片的对象Label
            JLabel jLabel = new JLabel(new ImageIcon("D:\\Java_Code\\untitled\\src\\image\\about.png"));
            //设置位置和宽高
            jLabel.setBounds(0, 0, 258, 258);
            //把图片添加到弹框当中
            jDialog.getContentPane().add(jLabel);
            //非弹框设置大小
            jDialog.setSize(344, 344);
            // 让弹框置顶
            jDialog.setAlwaysOnTop(true);
            //弹框居中
            jDialog.setLocationRelativeTo(null);
            //弹框不关闭，则无法操作下面的界面
            jDialog.setModal(true);
            //让弹框显示出来
            jDialog.setVisible(true);
        } else if (obj == beautyItem) {
            System.out.println("更换美女照片");
            //更换路径path后重新调用方法
            Random r = new Random();
            path = "D:\\Java_Code\\untitled\\src\\image\\girl\\girl" + (r.nextInt(12) + 1) + "\\";
            //重新加载数据
            initData();
            step = 0;
            //加载图片
            initImage();
            this.setVisible(true);
        } else if (obj == animalItem) {
            Random r = new Random();
            path = "D:\\Java_Code\\untitled\\src\\image\\animal\\animal" + (r.nextInt(8) + 1) + "\\";
            initData();
            initImage();
            System.out.println("更换动物照片");
        } else if (obj == sportItem) {
            Random r = new Random();
            path = "D:\\Java_Code\\untitled\\src\\image\\sport\\sport" + (r.nextInt(10) + 1) + "\\";
            initData();
            initImage();
            System.out.println("更换运动照片");
        }
    }
}
