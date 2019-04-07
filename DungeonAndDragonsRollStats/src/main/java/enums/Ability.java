package enums;

import java.util.Arrays;
import java.util.List;

public enum Ability {
	
	Charisma(Arrays.asList(
			Skill.Deception,
			Skill.Intimidation,
			Skill.Performance,
			Skill.Persuasion)),
	Constitution(Arrays.asList()),
	Intelligence(Arrays.asList(
					Skill.Arcana,
					Skill.History,
					Skill.Investigation,
					Skill.Nature,
					Skill.Religion)),
	Dexterity(Arrays.asList(
			Skill.Acrobatics,
			Skill.Sleight_Of_Hand,
			Skill.Stealth)),
	Strength(Arrays.asList(Skill.Athletics)),
	Wisdom(Arrays.asList(
			Skill.Animal_Handling,
			Skill.Insight,
			Skill.Medicine,
			Skill.Perception,
			Skill.Survival));
	
	private List<Skill> skills;
	
	private Ability(List<Skill> skills) {
		this.skills = skills;
	}
	
	public List<Skill> getSkills() {
		return this.skills;
	};
}
