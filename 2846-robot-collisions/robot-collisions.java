
class Robot {
    int position;
    int health;
    char direction;
    int index;

    Robot(int position, int health, char direction, int index) {
        this.position = position;
        this.health = health;
        this.direction = direction;
        this.index = index;
    }
}

public class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Robot[] robots = new Robot[n];
        
        for (int i = 0; i < n; i++) {
            robots[i] = new Robot(positions[i], healths[i], directions.charAt(i), i);
        }
        
        Arrays.sort(robots, Comparator.comparingInt(r -> r.position));
        
        Stack<Robot> stack = new Stack<>();
        
        for (Robot robot : robots) {
            if (robot.direction == 'R') {
                stack.push(robot);
            } else {
                while (!stack.isEmpty() && stack.peek().direction == 'R') {
                    Robot rightRobot = stack.pop();
                    if (rightRobot.health > robot.health) {
                        rightRobot.health -= 1;
                        stack.push(rightRobot);
                        robot = null;
                        break;
                    } else if (rightRobot.health < robot.health) {
                        robot.health -= 1;
                    } else {
                        robot = null;
                        break;
                    }
                }
                if (robot != null) {
                    stack.push(robot);
                }
            }
        }
        
        List<Robot> survivors = new ArrayList<>(stack);
        survivors.sort(Comparator.comparingInt(r -> r.index));
        
        List<Integer> result = new ArrayList<>();
        for (Robot survivor : survivors) {
            result.add(survivor.health);
        }
        
        return result;
    }
}