package Practice;

public class VariantCollection {
    Node root;

    public static void main(String[] args) {
        VariantCollection col = new VariantCollection();
        col.addVariant(new CovidVariant("Alpha", "210201A"));
        col.addVariant(new CovidVariant("Delta", "210311D"));
        col.addVariant(new CovidVariant("Beta", "210311A"));
        col.addVariant(new CovidVariant("Omicron", "211120D"));
        System.out.println(col.search("210311A").name); // return the Beta variant
        System.out.println(col.previous("211120D").uniqueCode); // return the Delta variant
    }

    public CovidVariant previous(String code) {
        if (root.value.compareTo(code) == 0) {
            return null;
        }

        Node tmp = root;
        Node parent = null;
        while (tmp != null) {
            if (tmp.value.compareTo(code) < 0) {
                parent = tmp;
                tmp = tmp.right;
            } else if (tmp.value.compareTo(code) > 0) {
                parent = tmp;
                tmp = tmp.left;
            } else {
                if (tmp.left == null) {
                    return parent.value;
                }
                return tmp.left.value;
            }
        }
        return null;
    }

    public CovidVariant search(String code) {
        Node tmp = root;
        while (tmp != null) {
            if (tmp.value.compareTo(code) < 0) {
                tmp = tmp.right;
            } else if (tmp.value.compareTo(code) > 0) {
                tmp = tmp.left;
            } else {
                return tmp.value;
            }
        }
        return null;
    }

    public void addVariant(CovidVariant v) {
        Node node = new Node(v);
        if (root == null) {
            root = node;
            return;
        }
        Node tmp = root;
        while (true) {
            if (tmp.value.compareTo(v) > 0) {
                if (tmp.left == null) {
                    tmp.left = node;
                    break;
                } else {
                    tmp = tmp.left;
                }
            } else {
                if (tmp.right == null) {
                    tmp.right = node;
                    break;
                } else {
                    tmp = tmp.right;
                }
            }
        }
    }

    static class CovidVariant {
        String name;
        String uniqueCode;

        CovidVariant(String name, String uniqueCode) {
            this.name = name;
            this.uniqueCode = uniqueCode;
        }

        public int compareTo(CovidVariant v) {
            int year1 = Integer.parseInt(uniqueCode.substring(0, 2));
            int year2 = Integer.parseInt(v.uniqueCode.substring(0, 2));
            int month1 = Integer.parseInt(uniqueCode.substring(2, 4));
            int month2 = Integer.parseInt(v.uniqueCode.substring(2, 4));
            int day1 = Integer.parseInt(uniqueCode.substring(4, 6));
            int day2 = Integer.parseInt(v.uniqueCode.substring(4, 6));
            String order1 = uniqueCode.substring(6);
            String order2 = v.uniqueCode.substring(6);
            if (year1 < year2) {
                return -1;
            } else if (year1 > year2) {
                return 1;
            } else {
                if (month1 < month2) {
                    return -1;
                } else if (month1 > month2) {
                    return 1;
                } else {
                    if (day1 < day2) {
                        return -1;
                    } else if (day1 > day2) {
                        return 1;
                    } else {
                        return order1.compareTo(order2);
                    }
                }
            }
        }

        public int compareTo(String v) {
            int year1 = Integer.parseInt(uniqueCode.substring(0, 2));
            int year2 = Integer.parseInt(v.substring(0, 2));
            int month1 = Integer.parseInt(uniqueCode.substring(2, 4));
            int month2 = Integer.parseInt(v.substring(2, 4));
            int day1 = Integer.parseInt(uniqueCode.substring(4, 6));
            int day2 = Integer.parseInt(v.substring(4, 6));
            String order1 = uniqueCode.substring(6);
            String order2 = v.substring(6);
            if (year1 < year2) {
                return -1;
            } else if (year1 > year2) {
                return 1;
            } else {
                if (month1 < month2) {
                    return -1;
                } else if (month1 > month2) {
                    return 1;
                } else {
                    if (day1 < day2) {
                        return -1;
                    } else if (day1 > day2) {
                        return 1;
                    } else {
                        return order1.compareTo(order2);
                    }
                }
            }
        }

    }


    static class Node {
        CovidVariant value;
        Node left, right;

        Node(CovidVariant v) {
            value = v;
            left = right = null;
        }
    }
}
