package query

import hibernate.model.Consoles

class QueriesTest {


    void testQuery1() {
        Queries testq1 = new Queries();
        testq1.class.query1();
    }

    void testQuery2() {
        Queries testq2 = new Queries();
        testq2.class.query2();
    }
}
