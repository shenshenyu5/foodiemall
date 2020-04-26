package com.imooc.service;

import com.imooc.pojo.Stu;

public interface StuService {
    public Stu getStuInfo(int id);
    public void saveStuInfo();
    public void updateStuInfo(int id);
    public void deleteStuInfo(int id);
    public void saveParent();
    public void saveChildren();
}
