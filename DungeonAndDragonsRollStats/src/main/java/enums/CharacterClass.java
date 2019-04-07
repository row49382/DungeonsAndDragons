package main.enums;

import java.util.Arrays;
import java.util.List;

// TODO: talk to Alex about finishing class subclasses
public enum CharacterClass {
	Barbarian(Arrays.asList(
			CharacterSubClass.Cannibal,
			CharacterSubClass.PathOfTheAncestralGuardian,
			CharacterSubClass.PathOfTheBattleRager,
			CharacterSubClass.PathOfTheBerserker,
			CharacterSubClass.PathOfTheStormHerald,
			CharacterSubClass.PathOfTheTotemWarrior,
			CharacterSubClass.PathOfTheZealot)),
	Bard(Arrays.asList(
			CharacterSubClass.CollegeOfGlamour,
			CharacterSubClass.CollegeOfLore,
			CharacterSubClass.CollegeOfSatire,
			CharacterSubClass.CollegeOfSwords,
			CharacterSubClass.CollegeOfValor)),
	Cleric(Arrays.asList()),
	Druid(Arrays.asList()),
	Fighter(Arrays.asList()),
	Monk(Arrays.asList()),
	Paladin(Arrays.asList()),
	Ranger(Arrays.asList()),
	Rogue(Arrays.asList()),
	Sorcerer(Arrays.asList()),
	Warlock(Arrays.asList()),
	Wizard(Arrays.asList());
	
	private List<CharacterSubClass> subClasses;
	
	private CharacterClass(List<CharacterSubClass> subClasses) {
		this.subClasses = subClasses;
	}
	
	public List<CharacterSubClass> getSubClasses() {
		return this.subClasses;
	}
}
