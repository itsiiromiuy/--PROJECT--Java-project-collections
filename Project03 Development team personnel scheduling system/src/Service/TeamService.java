package Service;


import domain.Architect;
import domain.Designer;
import domain.Employee;
import domain.Programmer;

/**
 * @Description Management of development team members: add, delete, etc.
 */

public class TeamService {
    // counter为静态变量，用来为开发团队新增成员自动生成团队中的唯一ID，即memberId。（提示：应使用增1的方式）
    private static int counter = 1;
    //MAX_MEMBER：表示开发团队最大成员数
    private final int MAX_MEMBER = 5;
    //team数组：用来保存当前团队中的各成员对象
    private Programmer[] team = new Programmer[MAX_MEMBER];
    //total：记录团队成员的实际人数
    private int realCount;

    public TeamService() {
        super();
    }

    /**
     * @return 包含所有成员对象的数组，数组大小与成员人数一致
     * @description 获取开发团队中的所有成员
     */
    public Programmer[] getTeamList() {
        // 1) 创建新数组, 容量是计数器
        Programmer[] newTeamArr = new Programmer[realCount];
        // 2) 依次把内部数组中所有有效对象保存在新数组中
        for (int i = 0; i < newTeamArr.length; i++) {
            newTeamArr[i] = this.team[i];
        }
        // 3) 返回新数组
        return newTeamArr;
    }

    /**
     * @Description 将制定的员工添加到团队中
     * @Param 待添加成员的对象
     * @Exception 添加失败，TeamException中包含了失败原因
     */
    public void addMember(Employee employee) throws TeamException {
        //"团队已满, 无法添加"
        if (realCount >= MAX_MEMBER) {
            throw new TeamException("Team is full, can't add");
        }
        //"该成员不是开发人员，无法添加"
        if (!(employee instanceof Programmer)) {
            throw new TeamException("The member cannot be added because it is not part of the development team.");
        }
        //"该员已是团队成员"
       /* Programmer programmer = (Programmer) employee;
        if (programmer.getMemberId() != 0) {
            throw new TeamException("该员已是团队成员");
        }*/
        if (isExist(employee)) {
            throw new TeamException("The person is already a team member");
        }
        //"该员正在Vacation or Busy,，无法添加"
        Programmer programmer = (Programmer) employee;
        if (programmer.getStatus().equals(TeamStatus.Status.BUSY)) {
            throw new TeamException("The person is already a team member");
        } else if (programmer.getStatus().equals(TeamStatus.Status.VACATION)) {
            throw new TeamException("The person is on vacation");
        }


        int architect = 0;
        int designer = 0;
        int programmers = 0;
        //团队中至多只能有一名架构师，两名设计师，三名程序员
        //获取Team已有成员中架构师，程序员，设计师的人数。
        for (int i = 0; i < realCount; i++) {
            if (team[i] instanceof Architect) {
                architect++;
            } else if (team[i] instanceof Designer) {
                designer++;
            } else {
                programmers++;
            }
        }
        if (programmer instanceof Architect) {
            if (architect == 1) {
                throw new TeamException("There can be at most one Architect on the team");
            }
        } else if (programmer instanceof Designer) {
            if (designer == 2) {
                throw new TeamException("There can be at most two Designers on the team");
            }
        } else {
            if (programmers == 3) {
                throw new TeamException("There can be at most Three Programmers on the team");
            }
        }
        // 给新成员赋予TID, 并改状态
        programmer.setMemberId(counter++);
        programmer.setStatus(TeamStatus.Status.BUSY);
        // 把参数中的对象保存在数组中, 下标由计数器控制 // 调整计数器
        this.team[realCount++] = programmer; // 将programmer 添加到现有的team中
    }


    private boolean isExist(Employee employee) {
        for (int i = 0; i < realCount; i++) {
            if (team[i].getId() == employee.getId()) {
                return true;
            }
        }
        return false;
    }

    public void removeMember(int memberId) {

    }
}