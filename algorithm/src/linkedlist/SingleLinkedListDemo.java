package linkedlist;

import java.util.Stack;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //进行测试
        //先创建节点
       HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
       HeroNode hero2 = new HeroNode(2,"吴用","智多星");
       HeroNode hero3 = new HeroNode(3,"林冲","豹子头");
       HeroNode hero4 = new HeroNode(4,"鲁智深","花和尚");

       //创建一个链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);
//        singleLinkedList.add(hero4);

        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);

        //显示
        singleLinkedList.list();
        //测试逆序打印单链表
        System.out.println("逆序打印链表");
        reversePrint(singleLinkedList.getHead());

    }
    //将单链表反转
    public static void reversetList(HeroNode head) {
        //如果链表为空或只有一个节点，无需反转
        if(head.next==null||head.next.next==null){
            return;
        }
        //定义一个辅助的指针，
        HeroNode cur = head.next;
        HeroNode next =  null;//指向当前节点cur的下一个节点
        HeroNode reverseHead = new HeroNode(0,"","");
        while(cur != null) {
            next = cur.next;//先暂存当前节点的下一个节点
            cur.next = reverseHead.next;//将cur的下一个节点指向新链表的最前端
            reverseHead.next = cur;//将cur连接到新链表上
            cur = next;//让cur后移
        }
        //将head.next 指向reverseHead.next
        head.next = reverseHead.next;
    }
    //从尾到头打印单链表，使用stack
    public static void reversePrint(HeroNode head) {
        if (head.next == null) {
            return;
        }
        Stack<HeroNode> stack = new Stack<HeroNode>();
        HeroNode cur = head.next;
        //压zhan
        while(cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        //打印
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }
}

//定义单链表 管理英雄人物
class SingleLinkedList {
    //初始化一个头结点，头结点不要动，不存放具体的数据
    private HeroNode head = new HeroNode(0, "", "");

    //返回头结点
    public HeroNode getHead() {
        return head;
    }
    //添加节点到单链表，关键是找到尾节点
    public void add(HeroNode hero) {
        //辅助节点，指向head
        HeroNode temp = head;
        //遍历链表，找到最后节点
        while (true) {
            if (temp.next == null) {
                break;
            }
            //如果没有找到最后，将temp后移
            temp = temp.next;
        }
        //当退出while循环时，
        temp.next = hero;
    }
    //
    public void addByOrder(HeroNode heroNode) {
        //因为头结点不能动，需要辅助指针
        HeroNode temp = head;
        boolean flag = false;
        while(true) {
            if(temp.next == null){
                break;
            } else if(temp.next.no > heroNode.no) {
                break;
            } else if (temp.next.no == heroNode.no) {
                flag = true;
                break;
            }
            //后移
            temp = temp.next;
        }
        //判断flag的值
        if (flag) {
            System.out.printf("准备插入的英雄的编码%d已经存在",heroNode.no);
            System.out.println();
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }
    //更新链表
    public void update(HeroNode newHeroNode) {

    }


    //显示链表
    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头结点不能动,需要一个辅助节点
        HeroNode temp = head.next;

        while (true) {
            //判断链表是否到最后
            if (temp == null) {
                break;
            }
            //输出节点信息
            System.out.println(temp);
            //将temp后移
            temp = temp.next;
        }
    }
}

//定义HeroNode，每个HeadNode就是一个节点
class HeroNode {
    //节点信息有编码，名字，昵称，下一个节点
    public int no;
    public String name;
    public String nikename;
    public HeroNode next;//

    //构造器
    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nikename = nickname;
    }

    //为了显示方便，重写toString
    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nikename='" + nikename + '\'' +
                '}';
    }
}