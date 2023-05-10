package fighters.derived;

import fighters.base.Attackable;
import fighters.base.Unit;
import logic.BattleUtils;

public class Wizard extends Unit implements Attackable{

	public Wizard(int maxHealth, int speed, int power ,  int location) {
		super("Wizard", "w", maxHealth, speed, location, true);
		setPower(power);
		setRange(2);
	}

	@Override
	public int attack(Unit e) {
		if (sameTeam(e) || !BattleUtils.validRange(getRange(), getLocation(), e.getLocation())) return-1;
		BattleUtils.calculateDamage(getPower(), e);
		return getPower();
	}

}
