package is204.users.service;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import is204.users.dao.UserDaoImpl;
import is204.users.model.User;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserDaoImpl userDao;

    public void addUser(User user) {
        userDao.addUser(user);
    }

//    public void updateMember(User user) {
//        userDao.updateMember(user);
//    }

//    public Member getMember(int id) {
//        return memberDAO.getMember(id);
//    }

//    public void deleteMember(int id) {
//        memberDAO.deleteMember(id);
//    }

//    public List<Member> getMembers() {
//        return memberDAO.getMembers();
//    }

//    public void storeAllMembers(List<Member> members) {
//
//        memberDAO.storeAllMembers(members);
//
//    }
}

