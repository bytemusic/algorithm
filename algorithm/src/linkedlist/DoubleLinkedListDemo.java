package linkedlist;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        System.out.println("双向链表的测试");
        HeroNodeDou hero1 = new HeroNodeDou(1,"宋江","及时雨");
        HeroNodeDou hero2 = new HeroNodeDou(2,"卢俊义","玉麒麟");
        HeroNodeDou hero3 = new HeroNodeDou(3,"吴用","智多星");
        HeroNodeDou hero4 = new HeroNodeDou(4,"武松","行者");

        //创建双链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);
        //显示
        doubleLinkedList.List();
        //修改
        HeroNodeDou newHeroNode = new HeroNodeDou(2,"公孙胜","入云龙");
        doubleLinkedList.update(newHeroNode);
        System.out.println("修改后");
        doubleLinkedList.List();
        //删除

        doubleLinkedList.del(3);
        System.out.println("删除后");
        doubleLinkedList.List();

    }
}
class DoubleLinkedList {
    //初始化一个头节点
    private HeroNodeDou head = new HeroNodeDou(0,"","");

    //返回头结点
    public HeroNodeDou getHead() {
        return head;
    }
    //添加
    public void add(HeroNodeDou heroNode) {
        //需要一个辅助链表
        HeroNodeDou temp = head;
        while(true) {
            if(temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
        heroNode.pre = temp;
    }
    //修改双链表
    public void update(HeroNodeDou newHeroNode) {
        if(head.next == null) {
            System.out.println("链表为空～");
            return;
        }
        //定义一个辅助变量
        HeroNodeDou temp = head.next;
        boolean flag = false;
        while(true) {
            if(temp == null) {
                break;
            }
            if(temp.no == newHeroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag) {
            temp.name = newHeroNode.name;
            temp.nikename = newHeroNode.nikename;
        }else {
            System.out.printf("没有找到%d\n",newHeroNode);
        }
    }
    //删除节点。对于双链表直接找到要删除的节点
    public void del(int no) {
        if(head.next == null) {
            System.out.println("表空");
            return;
        }
        HeroNodeDou temp = head.next;
        Boolean flag = false;
        while(true) {
            if(temp == null) {
                break;
            }
            if(temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag) {
            //如果是最后一个节点不需要删除，否者回报空指针异常
            temp.pre.next = temp.next;
            if(temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.printf("要删除节点%d不存在\n",no);
        }
    }

    //遍历链表
    public void List() {
        //判断链表是否为空
        if(head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //需要一个辅助链表
        HeroNodeDou temp = head.next;
        while(true) {
            if(temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
}

class HeroNodeDou {
    //节点信息有编码，名字，昵称，下一个节点
    public int no;
    public String name;
    public String nikename;
    public HeroNodeDou pre;//指向下一个节点，默认为null
    public HeroNodeDou  next;//

    //构造器
    public HeroNodeDou(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nikename = nickname;
    }

    @Override
    public String toString() {
        return "HeroNodeDou{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nikename='" + nikename + '\'' +
                '}';
    }
}