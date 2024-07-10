package Scripts;

public class b_PrintingResultDataOfMultipleStudents {

    public b_PrintingResultDataOfMultipleStudents(int StartId, int Count) {

        a_PrintingResultDataOfOneStudent script = new a_PrintingResultDataOfOneStudent(this.formatStudentId(StartId));
        script.doRun();

        for (int i=StartId+1; i<=StartId+Count; i++) {

            script.StudentId = this.formatStudentId(i);
            script.doRun();

        }

        script.closeDriver();

    }

    /**
     * This method will format the student id for CE branch
     * of batch 2020. You just need to provide integer id,
     * and it will be formatted into 20CE***
     *
     * @param id The integer student id
     * @return formatted student id for the provided integer id
     * */
    private String formatStudentId(int id) {
        String PaddedStudentId = String.format("%3s",String.valueOf(id)).replace(" ","0");
        return "20CE".concat(PaddedStudentId);
    }

    public static void main(String[] args) {

        new b_PrintingResultDataOfMultipleStudents(1, 1);

    }

}
