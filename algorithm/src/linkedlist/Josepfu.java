package linkedlist;

public class Josepfu {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.showBoy();
        //测试小孩出圈
        circleSingleLinkedList.countBoy(1,2,5);

    }
}
//创建一个环形的单向链表
class CircleSingleLinkedList {
    //创建一个first节点，当前没有编号
    private Boy first = new Boy(-1);
    //添加小孩节点，构建成一个环形的链表
    public void addBoy(int nums) {
        //对num进行校验
        if(nums < 1) {
            System.out.println("nums值不正确");
        }
        Boy curBoy = null;//辅助指针，帮助构建环形链表
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            //如果是第一个小孩
            if (i == 1) {
                first = boy;
                first.setNext(first);//
                curBoy = first;//让curBoy指向第一个小孩
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }
    //遍历
    public void showBoy() {
        if(first == null) {
            System.out.println("没有小孩");
            return;
        }
        //需要一个辅助指针
        Boy curBoy = first;
        while(true) {
            System.out.printf("小孩编号%d\n",curBoy.getNo());
            if(curBoy.getNext() == first) {
                break;
            }
            curBoy = curBoy.getNext();
        }
    }
    //根据用户的输入，计算出小孩出圈的顺序
    /*
     *@param startNo 表示从第一个小孩数
     *@param countNum 表示数几下
     *@param nums表示最初有多少小孩出圈中
     */
    public void countBoy(int startNo, int countNum, int nums) {
        if(first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数错误，请重新输入");
            return;
        }
        //创建辅助指针
        Boy helper = first;
        while(true) {
            if(helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }
        //补充： 小孩报数前，先让 first 和  helper 移动 k - 1次
        for (int j = 0; j < startNo -1 ; j++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        //当小孩报数时，让first 和 helper 指针同时 的移动  m  - 1 次
        //这是一个循环操作，直到圈子只有一个人
        while(true) {
            if(helper == first) {
                break;
            }
            //循环
            for (int j = 0; j < countNum -1; j++){
                first = first.getNext();
                helper = helper.getNext();
            }
            //让first指向小孩节点出圈
            System.out.printf("小孩%d出圈\n",first.getNo());
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后留在圈子的小孩编号%d\n",first.getNo());
    }
 }
//先创建一个Boy类,表示一个节点
class Boy {
    private int no;//编号
    private Boy next;//指向下一个节点，默认null
    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}