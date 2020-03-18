package org.example;

import java.io.Serializable;

public class dataClass implements Comparable<dataClass> , Serializable {

    private static final long serialVersionUID = -5243901184267064976L;

    private int id;

    private String name;

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        dataClass other = (dataClass) obj;
        if (id != other.id)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "dataClass [name=" + name + ", id=" + id + "]";
    }

    @Override
    public int compareTo(dataClass other) {
        int byName = this.name.compareTo(other.getName());
        return byName;
    }

}

