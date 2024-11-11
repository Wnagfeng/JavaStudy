package org.example.service;

import org.example.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//标识服务层组件：@Service用于定义服务类，该类通常包含业务逻辑，并与数据访问层（如DAO层）进行交互。它帮助开发者清晰地识别哪些类是专门负责业务逻辑处理的。
//
//自动注入：与其他Spring的组件注解（如@Controller和@Repository）一样，@Service类也会被Spring容器自动扫描并管理，支持依赖注入。这意味着可以通过@Autowired将其注入到其他类中，方便管理和使用。
//
//类的职责分离：使用@Service将业务逻辑与其他层（如控制层和数据访问层）分离，有助于维护代码的清晰性和可读性。这样的职责划分符合分层架构的设计原则，使得代码更易于测试和维护。

@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    /**
     * 添加事务：
     *
     * @Transactional 位置： 方法 | 类上
     * 方法： 当前方法有事务
     * 类上： 类下的所有方法都有事务
     * <p>
     * 1.只读模式
     * 只读模式可以提升查询事务的效率！ 推荐事务中只有查询代码，使用只读模式！
     * 默认： boolean readOnly() default false;
     * 解释： 一般情况下，都是通过类添加注解添加事务！
     * 类下的所有方法都有事务！
     * 查询方法可以通过再次添加注解，设置为只读模式，提高效率!
     * <p>
     * 2.超时时间
     * 默认： 永远不超时  -1
     * 设置 timeout = 时间 秒数  超过时间，就会回滚事务和释放异常！ TransactionTimedOutException
     * 如果类上设置事务属性，方法也设置了事务注解！ 方法会不会生效？？
     * 不会生效： 方法上的注解覆盖了类上的注解！
     * <p>
     * 3.指定异常回滚和指定异常不回滚：
     * 默认情况下，指定发生运行时异常事务才会回滚！
     * 我们可以指定Exception异常来控制所有异常都回滚！
     * rollbackFor = Exception.class
     * noRollbackFor = 回滚异常范围内，控制某个异常不回滚！
     * <p>
     * 4.隔离级别设置
     * 推荐设置第二个隔离级别！
     * isolation = Isolation.READ_COMMITTED
     */
    @Transactional
    public void changeInfo() {
        studentDao.updateAgeById(1100, 1);
        //比如我们在这里进行一个错误的操作如果他上面更新id成功了就没有事务
        //如果啥都没改就是有事务进来了管理我们的程序了
        //这样做的好处就是保证了一个程序的或者说一个事务的完整性
        int i = 1 / 0;
        System.out.println("-----------");
        studentDao.updateNameById("test11", 1);
    }
}
