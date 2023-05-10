package logic;

public class Fighter extends Piece{

	private boolean promoted;
	private PositionList promotedMovePositions;
	
	public Fighter(int initialPositionX, int initialPositionY, boolean reverse, String name) {
		super(initialPositionX, initialPositionY, reverse, name);
		promotedMovePositions = new PositionList();
		promoted = false;
		
		movePositions.add(-1,2);
		movePositions.add(1,2);
		
		promotedMovePositions.add(0,2);
		promotedMovePositions.add(1,0);
		promotedMovePositions.add(0,-2);
		promotedMovePositions.add(-1,0);
		
		if (isReverse()) {
			for (Position p:getMovePositions()) {
				p.reverse();
			}
			for (Position p:getPromotedMovePositions()) {
				p.reverse();
			}
		}
	}
	@Override
	public void move(int movePattern) {
		// TODO Auto-generated method stub
		Position mp ;
		if (!promoted) {
			mp = movePositions.get(movePattern);
			
		}
		else {
			mp = promotedMovePositions.get(movePattern);
		}
		setCurrentPosition(getCurrentPosition().addPositionValue(mp));
	}

	@Override
	public Position attackTargetPosition(int actionPattern) {
		move(actionPattern);
		return getCurrentPosition();
	}
	public boolean isPromoted() {
		return promoted;
	}
	public void setPromoted(boolean promoted) {
		this.promoted = promoted;
	}
	public PositionList getPromotedMovePositions() {
		return promotedMovePositions;
	}
}
