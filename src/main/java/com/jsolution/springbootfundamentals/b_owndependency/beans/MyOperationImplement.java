package com.jsolution.springbootfundamentals.b_owndependency.beans;

import com.jsolution.springbootfundamentals.b_owndependency.beans.interfaces.MyOperation;

public class MyOperationImplement implements MyOperation {
    @Override
    public int sum(int number) {
        return 0;
    }
}
