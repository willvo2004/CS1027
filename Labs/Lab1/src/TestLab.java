public class TestLab {
    public static void main(String[] args) {
        Player p1 = new Player("Will", "GK", 1);

        System.out.println(p1.getName());
        System.out.println(p1.getPosition());
        System.out.println(p1.getJerseyNum());

        p1.setName("Wayne Gretsky");
        p1.setPosition("Center");
        p1.setJerseyNum(87);

        System.out.println(p1.getName());
        System.out.println(p1.getPosition());
        System.out.println(p1.getJerseyNum());

        System.out.println(p1);

        Player p2 = new Player("Wayne Gretsky", "Center", 87);

        if (p1.equals(p2)) {
            System.out.println("Same player");
        } else {
            System.out.println("Different player");
        }
    }
}