package enums;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum CharacterRace {
	Dragonborn(Arrays.asList()),
	Dwarf(Arrays.asList(
			CharacterSubRace.HillDwarf,
			CharacterSubRace.MountainDwarf,
			CharacterSubRace.DuergarDwarf)),
	Elf(Arrays.asList(
			CharacterSubRace.HighElf,
			CharacterSubRace.WoodElf,
			CharacterSubRace.DrowElf,
			CharacterSubRace.EladrinElf,
			CharacterSubRace.SeaElf,
			CharacterSubRace.Shadar_Kai_Elf)),
	Gnome(Arrays.asList(
			CharacterSubRace.ForestGnome,
			CharacterSubRace.RockGnome,
			CharacterSubRace.SvirfneblinGnome)),
	Aasimar(Arrays.asList(
			CharacterSubRace.ProtectorAasimar,
			CharacterSubRace.ScourgeAasimar,
			CharacterSubRace.FallenAasimar)),
	BugBear(Arrays.asList()),
	Firbolg(Arrays.asList()),
	Goblin(Arrays.asList()),
	Grung(Arrays.asList()),
	Hobgoblin(Arrays.asList()),
	Kenku(Arrays.asList()),
	Kibold(Arrays.asList()),
	Lizardfolk(Arrays.asList()),
	Orc(Arrays.asList()),
	Tabaxi(Arrays.asList()),
	Triton(Arrays.asList()),
	Yuan_Ti_Pureblood(Arrays.asList()) {
		@Override
		public String toString() {
			return "Yuan-Ti Pureblood";
		}
		
	},
	Mousefolk(Arrays.asList(
			CharacterSubRace.MeadowguardMouseFolk,
			CharacterSubRace.SoftpawMouseFolk)),
	Half_Elf(Arrays.asList(
			CharacterSubRace.Regular,
			CharacterSubRace.Variant)) {
		@Override
		public String toString() {
			return "Half-Elf";
		}
	},
	Halfling(Arrays.asList(
			CharacterSubRace.LightfootHalfling,
			CharacterSubRace.StoutHalfling,
			CharacterSubRace.GhostwiseHalfling)),
	Half_Orc(Arrays.asList(
			CharacterSubRace.Regular,
			CharacterSubRace.Variant)) {
		@Override
		public String toString() {
			return "Half-Orc";
		}
	},
	Human(Arrays.asList(
			CharacterSubRace.LightfootHalfling,
			CharacterSubRace.StoutHalfling)),
	Tiefling(Arrays.asList(
			CharacterSubRace.Regular,
			CharacterSubRace.Variant)),
	Aarakocra(Arrays.asList(
			CharacterSubRace.AirAarakocra,
			CharacterSubRace.EarthAarakocra,
			CharacterSubRace.FireAarakocra,
			CharacterSubRace.WaterAarakocra)),
	Genasi(Arrays.asList(
			CharacterSubRace.AirGenesi,
			CharacterSubRace.EarthGenesi,
			CharacterSubRace.FireGenesi,
			CharacterSubRace.WaterGenesi)),
	Goliath(Arrays.asList());
	
	private List<CharacterSubRace> subRaces;
	private Map<Ability, Integer> abilityScoreIncreases;
	
	private CharacterRace(List<CharacterSubRace> subRaces) {
		this.subRaces = subRaces;
	}
	
	public List<CharacterSubRace> getSubRaces() {
	    return this.subRaces;
	}
	
	public Map<Ability, Integer> getAbilityScoreIncreases() {
		return this.abilityScoreIncreases;
	}

    /**
     * Setups the ability score increases that will be applied
     * based on proficiency/expertise
     * 
     * Still need to design means for implementation
     * @param abilityScoreIncreases
     * @return 
     */
	private static Map<Ability, Integer> setupAbilityScoreIncreases(List<AbstractMap.SimpleEntry<Ability, Integer>> abilityScoreIncreases) {
		Map<Ability, Integer> map = new HashMap<>();
		
		for (Map.Entry<Ability, Integer> entry: abilityScoreIncreases) {
			map.put(entry.getKey(), entry.getValue());
		}
		
		return map;
	}
	
	public static String listValues() {
		String s = "";
		
		for (CharacterRace charRace: values()) {
			s += String.format("- %s \n", charRace);
		}
		
		return s;
	}
}
