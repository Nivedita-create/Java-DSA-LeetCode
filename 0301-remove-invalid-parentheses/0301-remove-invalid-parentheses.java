class Solution {
    public List<String> removeInvalidParentheses(String s) {

        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(s);
        visited.add(s);

        while(!queue.isEmpty()) {

            int size = queue.size();

            for(int j = 0; j < size; j++) {

                String curr = queue.poll();

                if(isValid(curr)) {
                    result.add(curr);
                }

                for(int i = 0; i < curr.length(); i++) {

                    if(curr.charAt(i) != '(' &&
                       curr.charAt(i) != ')') {
                        continue;
                    }

                    String next = curr.substring(0, i)
                                + curr.substring(i + 1);

                    if(!visited.contains(next)) {
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }

            if(!result.isEmpty()) {
                return result;
            }
        }

        return result;
    }

    public boolean isValid(String s) {

        int count = 0;

        for(int i = 0; i < s.length(); i++) {

            if(s.charAt(i) == '(') {
                count++;
            }
            else if(s.charAt(i) == ')') {
                count--;
            }

            if(count < 0) {
                return false;
            }
        }

        return count == 0;
    }
}