package enums;

import java.util.Arrays;
import java.util.List;

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
			CharacterSubClass.CollegeOfValor,
			CharacterSubClass.CollegeOfWhispers)),
	Cleric(Arrays.asList(
			CharacterSubClass.ArcanaDomain,
			CharacterSubClass.DeathDomoain,
			CharacterSubClass.CityDomain,
			CharacterSubClass.ForgeDomain,
			CharacterSubClass.GraveDomain,
			CharacterSubClass.KnowledgeDomain,
			CharacterSubClass.LifeDomain,
			CharacterSubClass.LightDomain,
			CharacterSubClass.NatureDomain,
			CharacterSubClass.TempestDomain,
			CharacterSubClass.TrickeryDomain,
			CharacterSubClass.WarDomain)),
	Druid(Arrays.asList(
			CharacterSubClass.CircleOfDreams,
			CharacterSubClass.CircleOfTheLand,
			CharacterSubClass.CirleOfTheMoon,
			CharacterSubClass.CircleOfSpores,
			CharacterSubClass.CircleOfTwilight)),
	Fighter(Arrays.asList(
			CharacterSubClass.ArcaneArcher,
			CharacterSubClass.Banneret,
			CharacterSubClass.Brute,
			CharacterSubClass.Cavlier,
			CharacterSubClass.Champion,
			CharacterSubClass.EldritchKnight,
			CharacterSubClass.Knight,
			CharacterSubClass.Samurai,
			CharacterSubClass.Sharpshooter)),
	Monk(Arrays.asList(
			CharacterSubClass.WayOfTheDrunkenMaster,
			CharacterSubClass.WayOfTheFourElements,
			CharacterSubClass.WayOfTheKensel,
			CharacterSubClass.WayOfTheLongDeath,
			CharacterSubClass.WayOfTheOpenHand,
			CharacterSubClass.WayOfShadow,
			CharacterSubClass.WayOfTheSunSould,
			CharacterSubClass.WayOfTranquility)),
	Paladin(Arrays.asList(
			CharacterSubClass.OathOfTheAncients,
			CharacterSubClass.OathOfConquest,
			CharacterSubClass.OathOfTheCrown,
			CharacterSubClass.OathOfDevotion,
			CharacterSubClass.OathOfRedemption,
			CharacterSubClass.OathOfTreachery,
			CharacterSubClass.OathOfVengeance,
			CharacterSubClass.Oathbreaker)),
	Ranger(Arrays.asList(
			CharacterSubClass.BeastMaster,
			CharacterSubClass.GloomStalker,
			CharacterSubClass.HorizonWalker,
			CharacterSubClass.Hunter,
			CharacterSubClass.MonsterSlayer,
			CharacterSubClass.PrimevalGuardian)),
	Rogue(Arrays.asList(
			CharacterSubClass.ArcaneTrickster,
			CharacterSubClass.Assassin,
			CharacterSubClass.Inquisitive,
			CharacterSubClass.Mastermind,
			CharacterSubClass.Scout,
			CharacterSubClass.Swashbuckler,
			CharacterSubClass.Thief)),
	Sorcerer(Arrays.asList(
			CharacterSubClass.DivineSoul,
			CharacterSubClass.DraconicBloodline,
			CharacterSubClass.SeaSorcery,
			CharacterSubClass.ShadowMagic,
			CharacterSubClass.StoneSorcery,
			CharacterSubClass.StormSorcery,
			CharacterSubClass.WildMagic)),
	Warlock(Arrays.asList(
			CharacterSubClass.TheArchfey,
			CharacterSubClass.TheCelestial,
			CharacterSubClass.TheFiend,
			CharacterSubClass.GhostInTheMachine,
			CharacterSubClass.TheGreatOldOne,
			CharacterSubClass.TheHexblade,
			CharacterSubClass.TheRavenQueen,
			CharacterSubClass.TheSeeker,
			CharacterSubClass.TheUndying,
			CharacterSubClass.Artificer,
			CharacterSubClass.Bladesinging,
			CharacterSubClass.LoreMastery)),
	Wizard(Arrays.asList(
			CharacterSubClass.SchoolOfAbjuration,
			CharacterSubClass.SchoolOfConjuration,
			CharacterSubClass.SchoolOfDivination,
			CharacterSubClass.SchoolOfEnchantment,
			CharacterSubClass.SchoolOfEvocation,
			CharacterSubClass.SchoolOfIllusion,
			CharacterSubClass.SchoolOfInvention,
			CharacterSubClass.SchoolOfNecromancy,
			CharacterSubClass.SchoolOfTransmutation,
			CharacterSubClass.Technomancy,
			CharacterSubClass.Theurgy,
			CharacterSubClass.WarMagic));
	
	private List<CharacterSubClass> subClasses;
	
	private CharacterClass(List<CharacterSubClass> subClasses) {
		this.subClasses = subClasses;
	}
	
	public List<CharacterSubClass> getSubClasses() {
		return this.subClasses;
	}
}
