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
            if (!user.getUser_email().matches("/.+@.+\\..+/i")) list.add("Check your Email address. It seems to be wrong.");

            //user Name and Surname test
           tmp2=user.getUser_fullName().split(" ");
            if (!tmp2[0].trim().matches("[A-Za-zА-Яа-я]{2,20}")) list.add("Error in your Name. Only letters are allowed.");
            if (tmp2[0].trim().length()>20) list.add("Error in your Name. It's too long. No more than 20 letters.");
            if (!tmp2[1].trim().matches("[A-Za-zА-Яа-я]{2,20}")) list.add("Error in your Surname. Only letters are allowed.");
            if (tmp2[1].trim().length()>20) list.add("Error in your Surname. It's too long. No more than 20 letters.");

            //password test ? screening candidate x1
            if ((user.getUser_password().length()>30))  list.add("Error in your Password. No more than 30 symbols are allowed");
            if (!(user.getUser_password().matches("(.*[a-z]+.*[0-9]+.*[A-Z]+.*)" +
                    "|(.*[a-z]+.*[A-Z]+.*[0-9]+.*)|(.*[A-Z]+.*[a-z]+.*[0-9]+.*)|(.*[0-9]+.*[a-z]+.*[A-Z]+)|" +
                    "(.*[A-Z]+.*[0-9]+.*[a-z]+)|(.*[0-9]+.*[A-Z]+.*[a-z]+)")) )
            list.add("Error in your Password. You must have at 1 uppercase, 1 lowercase letter and at least 1 digit.");
            if (user.getUser_password().length()<5) list.add("Error in your Password. It's too short. At least 5 symbols are required.");

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
