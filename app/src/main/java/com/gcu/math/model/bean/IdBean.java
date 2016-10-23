package com.gcu.math.model.bean;

/**
 * Created by Martin on 2016/10/9.
 */
public  class IdBean {
    private String $oid;

    public String get$oid() {
        return $oid;
    }

    public void set$oid(String $oid) {
        this.$oid = $oid;
    }

    @Override
    public boolean equals(Object o) {
        return $oid.equals(((IdBean)o).get$oid());
    }
}