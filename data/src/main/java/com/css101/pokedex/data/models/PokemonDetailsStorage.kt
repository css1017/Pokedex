package com.css101.pokedex.data.models

import com.fasterxml.jackson.annotation.JsonProperty

data class PokemonDetailsStorage(
    @JsonProperty("abilities")
    val abilities: List<Ability>,
    @JsonProperty("base_experience")
    val baseExperience: Int,
    @JsonProperty("cries")
    val cries: Cries,
    @JsonProperty("forms")
    val forms: List<Form>,
    @JsonProperty("game_indices")
    val gameIndices: List<GameIndex>,
    @JsonProperty("height")
    val height: Int,
    @JsonProperty("held_items")
    val heldItems: List<HeldItem>,
    @JsonProperty("id")
    val id: Int,
    @JsonProperty("is_default")
    val isDefault: Boolean,
    @JsonProperty("location_area_encounters")
    val locationAreaEncounters: String,
    @JsonProperty("moves")
    val moves: List<Move>,
    @JsonProperty("name")
    val name: String,
    @JsonProperty("order")
    val order: Int,
    @JsonProperty("past_abilities")
    val pastAbilities: List<PastAbility>,
    @JsonProperty("past_types")
    val pastTypes: List<PastType>,
    @JsonProperty("species")
    val species: Species,
    @JsonProperty("sprites")
    val sprites: Sprites,
    @JsonProperty("stats")
    val stats: List<Stat>,
    @JsonProperty("types")
    val types: List<Type>,
    @JsonProperty("weight")
    val weight: Int
)

data class Ability(
    @JsonProperty("ability")
    val ability: AbilityDetails,
    @JsonProperty("is_hidden")
    val isHidden: Boolean,
    @JsonProperty("slot")
    val slot: Int
)

data class AbilityDetails(
    @JsonProperty("name")
    val name: String,
    @JsonProperty("url")
    val url: String
)

data class Cries(
    @JsonProperty("latest")
    val latest: String,
    @JsonProperty("legacy")
    val legacy: String?
)

data class Form(
    @JsonProperty("name")
    val name: String,
    @JsonProperty("url")
    val url: String
)

data class GameIndex(
    @JsonProperty("game_index")
    val gameIndex: Int,
    @JsonProperty("version")
    val version: Version
)

data class Version(
    @JsonProperty("name")
    val name: String,
    @JsonProperty("url")
    val url: String
)

data class HeldItem(
    @JsonProperty("item")
    val item: Item,
    @JsonProperty("version_details")
    val versionDetails: List<VersionDetail>
)

data class Item(
    @JsonProperty("name")
    val name: String,
    @JsonProperty("url")
    val url: String
)

data class VersionDetail(
    @JsonProperty("rarity")
    val rarity: Int,
    @JsonProperty("version")
    val version: Version
)

data class Move(
    @JsonProperty("move")
    val move: MoveDetails,
    @JsonProperty("version_group_details")
    val versionGroupDetails: List<VersionGroupDetail>
)

data class MoveDetails(
    @JsonProperty("name")
    val name: String,
    @JsonProperty("url")
    val url: String
)

data class VersionGroupDetail(
    @JsonProperty("level_learned_at")
    val levelLearnedAt: Int,
    @JsonProperty("move_learn_method")
    val moveLearnMethod: MoveLearnMethod,
    @JsonProperty("version_group")
    val versionGroup: VersionGroup
)

data class MoveLearnMethod(
    @JsonProperty("name")
    val name: String,
    @JsonProperty("url")
    val url: String
)

data class VersionGroup(
    @JsonProperty("name")
    val name: String,
    @JsonProperty("url")
    val url: String
)

data class Species(
    @JsonProperty("name")
    val name: String,
    @JsonProperty("url")
    val url: String
)

data class Sprites(
    @JsonProperty("back_default")
    val backDefault: String?,
    @JsonProperty("back_female")
    val backFemale: String?,
    @JsonProperty("back_shiny")
    val backShiny: String?,
    @JsonProperty("back_shiny_female")
    val backShinyFemale: String?,
    @JsonProperty("front_default")
    val frontDefault: String,
    @JsonProperty("front_female")
    val frontFemale: String?,
    @JsonProperty("front_shiny")
    val frontShiny: String,
    @JsonProperty("front_shiny_female")
    val frontShinyFemale: String?,
    @JsonProperty("other")
    val other: OtherSprites,
    @JsonProperty("versions")
    val versions: Versions
)

data class OtherSprites(
    @JsonProperty("dream_world")
    val dreamWorld: DreamWorldSprites,
    @JsonProperty("home")
    val home: HomeSprites,
    @JsonProperty("official-artwork")
    val officialArtwork: OfficialArtworkSprites,
    @JsonProperty("showdown")
    val showdown: ShowdownSprites
)

data class DreamWorldSprites(
    @JsonProperty("front_default")
    val frontDefault: String?,
    @JsonProperty("front_female")
    val frontFemale: String?
)

data class HomeSprites(
    @JsonProperty("front_default")
    val frontDefault: String,
    @JsonProperty("front_female")
    val frontFemale: String?,
    @JsonProperty("front_shiny")
    val frontShiny: String,
    @JsonProperty("front_shiny_female")
    val frontShinyFemale: String?
)

data class OfficialArtworkSprites(
    @JsonProperty("front_default")
    val frontDefault: String,
    @JsonProperty("front_shiny")
    val frontShiny: String
)

data class ShowdownSprites(
    @JsonProperty("back_default")
    val backDefault: String?,
    @JsonProperty("back_female")
    val backFemale: String?,
    @JsonProperty("back_shiny")
    val backShiny: String?,
    @JsonProperty("back_shiny_female")
    val backShinyFemale: String?,
    @JsonProperty("front_default")
    val frontDefault: String?,
    @JsonProperty("front_female")
    val frontFemale: String?,
    @JsonProperty("front_shiny")
    val frontShiny: String?,
    @JsonProperty("front_shiny_female")
    val frontShinyFemale: String?
)

data class Versions(
    @JsonProperty("generation-i")
    val generationI: GenerationISprites,
    @JsonProperty("generation-ii")
    val generationII: GenerationIISprites,
    @JsonProperty("generation-iii")
    val generationIII: GenerationIIISprites,
    @JsonProperty("generation-iv")
    val generationIV: GenerationIVSprites,
    @JsonProperty("generation-v")
    val generationV: GenerationVSprites,
    @JsonProperty("generation-vi")
    val generationVI: GenerationVISprites,
    @JsonProperty("generation-vii")
    val generationVII: GenerationVIISprites,
    @JsonProperty("generation-viii")
    val generationVIII: GenerationVIIISprites
)

data class GenerationISprites(
    @JsonProperty("red-blue")
    val redBlue: RedBlueSprites,
    @JsonProperty("yellow")
    val yellow: YellowSprites
)

data class RedBlueSprites(
    @JsonProperty("back_default")
    val backDefault: String?,
    @JsonProperty("back_gray")
    val backGray: String?,
    @JsonProperty("back_transparent")
    val backTransparent: String?,
    @JsonProperty("front_default")
    val frontDefault: String?,
    @JsonProperty("front_gray")
    val frontGray: String?,
    @JsonProperty("front_transparent")
    val frontTransparent: String?
)

data class YellowSprites(
    @JsonProperty("back_default")
    val backDefault: String?,
    @JsonProperty("back_gray")
    val backGray: String?,
    @JsonProperty("back_transparent")
    val backTransparent: String?,
    @JsonProperty("front_default")
    val frontDefault: String?,
    @JsonProperty("front_gray")
    val frontGray: String?,
    @JsonProperty("front_transparent")
    val frontTransparent: String?
)

data class GenerationIISprites(
    @JsonProperty("crystal")
    val crystal: CrystalSprites,
    @JsonProperty("gold")
    val gold: GoldSprites,
    @JsonProperty("silver")
    val silver: SilverSprites
)

data class CrystalSprites(
    @JsonProperty("back_default")
    val backDefault: String?,
    @JsonProperty("back_shiny")
    val backShiny: String?,
    @JsonProperty("back_shiny_transparent")
    val backShinyTransparent: String?,
    @JsonProperty("back_transparent")
    val backTransparent: String?,
    @JsonProperty("front_default")
    val frontDefault: String?,
    @JsonProperty("front_shiny")
    val frontShiny: String?,
    @JsonProperty("front_shiny_transparent")
    val frontShinyTransparent: String?,
    @JsonProperty("front_transparent")
    val frontTransparent: String?
)

data class GoldSprites(
    @JsonProperty("back_default")
    val backDefault: String?,
    @JsonProperty("back_shiny")
    val backShiny: String?,
    @JsonProperty("front_default")
    val frontDefault: String?,
    @JsonProperty("front_shiny")
    val frontShiny: String?,
    @JsonProperty("front_transparent")
    val frontTransparent: String?
)

data class SilverSprites(
    @JsonProperty("back_default")
    val backDefault: String?,
    @JsonProperty("back_shiny")
    val backShiny: String?,
    @JsonProperty("front_default")
    val frontDefault: String?,
    @JsonProperty("front_shiny")
    val frontShiny: String?,
    @JsonProperty("front_transparent")
    val frontTransparent: String?
)

data class GenerationIIISprites(
    @JsonProperty("emerald")
    val emerald: EmeraldSprites,
    @JsonProperty("firered-leafgreen")
    val fireredLeafgreen: FireredLeafgreenSprites,
    @JsonProperty("ruby-sapphire")
    val rubySapphire: RubySapphireSprites
)

data class EmeraldSprites(
    @JsonProperty("front_default")
    val frontDefault: String?,
    @JsonProperty("front_shiny")
    val frontShiny: String?
)

data class FireredLeafgreenSprites(
    @JsonProperty("back_default")
    val backDefault: String?,
    @JsonProperty("back_shiny")
    val backShiny: String?,
    @JsonProperty("front_default")
    val frontDefault: String?,
    @JsonProperty("front_shiny")
    val frontShiny: String?
)

data class RubySapphireSprites(
    @JsonProperty("back_default")
    val backDefault: String?,
    @JsonProperty("back_shiny")
    val backShiny: String?,
    @JsonProperty("front_default")
    val frontDefault: String?,
    @JsonProperty("front_shiny")
    val frontShiny: String?
)

data class GenerationIVSprites(
    @JsonProperty("diamond-pearl")
    val diamondPearl: DiamondPearlSprites,
    @JsonProperty("heartgold-soulsilver")
    val heartgoldSoulsilver: HeartgoldSoulsilverSprites,
    @JsonProperty("platinum")
    val platinum: PlatinumSprites
)

data class DiamondPearlSprites(
    @JsonProperty("back_default")
    val backDefault: String?,
    @JsonProperty("back_female")
    val backFemale: String?,
    @JsonProperty("back_shiny")
    val backShiny: String?,
    @JsonProperty("back_shiny_female")
    val backShinyFemale: String?,
    @JsonProperty("front_default")
    val frontDefault: String?,
    @JsonProperty("front_female")
    val frontFemale: String?,
    @JsonProperty("front_shiny")
    val frontShiny: String?,
    @JsonProperty("front_shiny_female")
    val frontShinyFemale: String?
)

data class HeartgoldSoulsilverSprites(
    @JsonProperty("back_default")
    val backDefault: String?,
    @JsonProperty("back_female")
    val backFemale: String?,
    @JsonProperty("back_shiny")
    val backShiny: String?,
    @JsonProperty("back_shiny_female")
    val backShinyFemale: String?,
    @JsonProperty("front_default")
    val frontDefault: String?,
    @JsonProperty("front_female")
    val frontFemale: String?,
    @JsonProperty("front_shiny")
    val frontShiny: String?,
    @JsonProperty("front_shiny_female")
    val frontShinyFemale: String?
)

data class PlatinumSprites(
    @JsonProperty("back_default")
    val backDefault: String?,
    @JsonProperty("back_female")
    val backFemale: String?,
    @JsonProperty("back_shiny")
    val backShiny: String?,
    @JsonProperty("back_shiny_female")
    val backShinyFemale: String?,
    @JsonProperty("front_default")
    val frontDefault: String?,
    @JsonProperty("front_female")
    val frontFemale: String?,
    @JsonProperty("front_shiny")
    val frontShiny: String?,
    @JsonProperty("front_shiny_female")
    val frontShinyFemale: String?
)

data class GenerationVSprites(
    @JsonProperty("black-white")
    val blackWhite: BlackWhiteSprites
)

data class BlackWhiteSprites(
    @JsonProperty("animated")
    val animated: AnimatedSprites,
    @JsonProperty("back_default")
    val backDefault: String?,
    @JsonProperty("back_female")
    val backFemale: String?,
    @JsonProperty("back_shiny")
    val backShiny: String?,
    @JsonProperty("back_shiny_female")
    val backShinyFemale: String?,
    @JsonProperty("front_default")
    val frontDefault: String?,
    @JsonProperty("front_female")
    val frontFemale: String?,
    @JsonProperty("front_shiny")
    val frontShiny: String?,
    @JsonProperty("front_shiny_female")
    val frontShinyFemale: String?
)

data class AnimatedSprites(
    @JsonProperty("back_default")
    val backDefault: String?,
    @JsonProperty("back_female")
    val backFemale: String?,
    @JsonProperty("back_shiny")
    val backShiny: String?,
    @JsonProperty("back_shiny_female")
    val backShinyFemale: String?,
    @JsonProperty("front_default")
    val frontDefault: String?,
    @JsonProperty("front_female")
    val frontFemale: String?,
    @JsonProperty("front_shiny")
    val frontShiny: String?,
    @JsonProperty("front_shiny_female")
    val frontShinyFemale: String?
)

data class GenerationVISprites(
    @JsonProperty("omegaruby-alphasapphire")
    val omegarubyAlphasapphire: OmegarubyAlphasapphireSprites,
    @JsonProperty("x-y")
    val xY: XYSprites
)

data class OmegarubyAlphasapphireSprites(
    @JsonProperty("front_default")
    val frontDefault: String?,
    @JsonProperty("front_female")
    val frontFemale: String?,
    @JsonProperty("front_shiny")
    val frontShiny: String?,
    @JsonProperty("front_shiny_female")
    val frontShinyFemale: String?
)

data class XYSprites(
    @JsonProperty("front_default")
    val frontDefault: String?,
    @JsonProperty("front_female")
    val frontFemale: String?,
    @JsonProperty("front_shiny")
    val frontShiny: String?,
    @JsonProperty("front_shiny_female")
    val frontShinyFemale: String?
)

data class GenerationVIISprites(
    @JsonProperty("icons")
    val icons: IconsSprites,
    @JsonProperty("ultra-sun-ultra-moon")
    val ultraSunUltraMoon: UltraSunUltraMoonSprites
)

data class IconsSprites(
    @JsonProperty("front_default")
    val frontDefault: String?,
    @JsonProperty("front_female")
    val frontFemale: String?
)

data class UltraSunUltraMoonSprites(
    @JsonProperty("front_default")
    val frontDefault: String?,
    @JsonProperty("front_female")
    val frontFemale: String?,
    @JsonProperty("front_shiny")
    val frontShiny: String?,
    @JsonProperty("front_shiny_female")
    val frontShinyFemale: String?
)

data class GenerationVIIISprites(
    @JsonProperty("icons")
    val icons: IconsSprites
)

data class Stat(
    @JsonProperty("base_stat")
    val baseStat: Int,
    @JsonProperty("effort")
    val effort: Int,
    @JsonProperty("stat")
    val stat: StatDetails
)

data class StatDetails(
    @JsonProperty("name")
    val name: String,
    @JsonProperty("url")
    val url: String
)

data class Type(
    @JsonProperty("slot")
    val slot: Int,
    @JsonProperty("type")
    val type: TypeDetails
)

data class TypeDetails(
    @JsonProperty("name")
    val name: String,
    @JsonProperty("url")
    val url: String
)

data class PastAbility(
    @JsonProperty("ability")
    val ability: AbilityDetails,
    @JsonProperty("is_hidden")
    val isHidden: Boolean,
    @JsonProperty("slot")
    val slot: Int,
    @JsonProperty("generation")
    val generation: Generation
)

data class Generation(
    @JsonProperty("name")
    val name: String,
    @JsonProperty("url")
    val url: String
)

data class PastType(
    @JsonProperty("slot")
    val slot: Int,
    @JsonProperty("type")
    val type: TypeDetails,
    @JsonProperty("generation")
    val generation: Generation
)