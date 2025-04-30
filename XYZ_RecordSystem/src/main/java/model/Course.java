package model;

import java.sql.Date;
import java.sql.Timestamp;

public class Course {

    private int courseId;
    private String courseCode;
    private String courseTitle;
    private String courseDesc;
    private Date courseStart;
    private Date courseEnd;
    private int courseStatus;
    private String courseCategory;
    private int isRemoved;
    private Timestamp createdAt;
    private Timestamp removedAt;


    public int getCourseId() {return courseId;}

    public void setCourseId(int courseId) {this.courseId = courseId;}

    public String getCourseCode() {return courseCode;}

    public void setCourseCode(String courseCode) {this.courseCode = courseCode;}

    public String getCourseTitle() {return courseTitle;}

    public void setCourseTitle(String courseTitle) {this.courseTitle = courseTitle;}

    public String getCourseDesc() {return courseDesc;}

    public void setCourseDesc(String courseDesc) {this.courseDesc = courseDesc;}

    public Date getCourseStart() {return courseStart;}

    public void setCourseStart(Date courseStart) {this.courseStart = courseStart;}

    public Date getCourseEnd() {return courseEnd;}

    public void setCourseEnd(Date courseEnd) {this.courseEnd = courseEnd;}

    public int getCourseStatus() {return courseStatus;}

    public void setCourseStatus(int courseStatus) {this.courseStatus = courseStatus;}

    public String getCourseCategory() {return courseCategory;}

    public void setCourseCategory(String courseCategory) {
        this.courseCategory = courseCategory;
    }

    public int getIsRemoved() {
        return isRemoved;
    }

    public void setIsRemoved(int isRemoved) {
        this.isRemoved = isRemoved;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getRemovedAt() {
        return removedAt;
    }

    public void setRemovedAt(Timestamp removedAt) {
        this.removedAt = removedAt;
    }
}
