package lesson03;

class FrogJump
{
	public int solution(int X, int Y, int D)
	{
		int distanceToJump = Y - X; // 75
		int jumpsRequired = distanceToJump / D; // 75/30
		if(distanceToJump % D !=0 ) { // 85%2.5
			jumpsRequired++; //if extra jump is required
		}
		return jumpsRequired;
	}
}
public class FrogJumpTest {
	public static void main(String[] args) {
		FrogJump frogJump = new FrogJump();
		int jumps1 = frogJump.solution(5, 50, 4);
		System.out.println("jumps1 : "+jumps1);
	}
}
