package ExamProjectNC.server;

import ExamProjectNC.shared.model.*;

import java.util.LinkedList;
import java.util.List;


public class UniversalFieldVerifier<E> {



    public List<String> verify(E entity){

       String tmp=entity.getClass().toString();
        String[] tmp2;
        List<String> list=new LinkedList<String>();

        if (tmp.matches(".*User$")){
            User user = (User)entity;

            //email test: check for '@' and dots
            if (!user.getUser_email().matches("^[-a-z0-9!#$%&'*+/=?^_`{|}~]+(?:\\.[-a-z0-9!#$%&'*+/=?^_`{|}~]+)*@(?:[a-z0-9]([-a-z0-9]{0,61}[a-z0-9])?\\.)*(?:aero|arpa|asia|biz|cat|com|coop|edu|gov|info|int|jobs|mil|mobi|museum|name|net|org|pro|tel|travel|[a-z][a-z])$")) list.add("Your email is wrong.");

            //user Name and Surname test
           tmp2=user.getUser_fullName().split(" ");
            if (tmp2.length>1) {
                if (!tmp2[0].trim().matches("[A-Za-zА-Яа-я]{2,20}"))
                    list.add("Name consists of restricted symbols.");
                if (tmp2[0].trim().length() > 20)
                    list.add("Your name is abnormally too long!");
                if (!tmp2[1].trim().matches("[A-Za-zА-Яа-я]{2,20}"))
                    list.add("Your surname consists of restricted symbols.");
                if (tmp2[1].trim().length() > 20)
                    list.add("Your surname is abnormally too long!");
            }

            //password test ? screening candidate x1
            if ((user.getUser_password().length()>30))  list.add("Password's max length is 30 symbols only.");
            if (!(user.getUser_password().matches(".*[A-Z].*")&(user.getUser_password().matches(".*[a-z].*"))&(user.getUser_password().matches(".*[0-9].*"))))
            list.add("Your password must contain at least 1 uppercase, 1 lowercase letter and 1 digit.");
            if (user.getUser_password().length()<5) list.add("At least 5 symbols are required in a password.");

        } else if (tmp.matches(".*Exam$")){
            Exam exam=(Exam)entity;

            //screening candidates x2
            if (exam.getExam_theme().matches("")){}
            if (exam.getExam_subject().matches("")){}

        } else if (tmp.matches(".*Group$")){
            Group group=(Group)entity;

            //screening candidate
            if (group.getGroup_name().matches("")){}

        }
        return list;
    }


}
