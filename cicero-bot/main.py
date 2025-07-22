from dotenv import load_dotenv
import os
import discord
from discord import app_commands
from discord.ext import commands
from asm_functions import *

load_dotenv()
DISCORD_TOKEN = os.getenv("DISCORD_TOKEN")

class Cicero(discord.Client):

    def __init__(self):
        intents = discord.Intents.default()

        super().__init__(
            intents=intents,
            commands_prefix="//"
        )

        self.tree = app_commands.CommandTree(self)


    async def setup_hook(self):
        await self.tree.sync()


    async def on_ready(self):
        print(f'{self.user} has connected to Discord!')


bot = Cicero()

class asmModal(discord.ui.Modal, title='Assimilação Roll Values'):

    def __init__(self, instinct_sides: int, knowledge_sides: int, roll_type: str):
        super().__init__()
        self.instinct_sides = instinct_sides
        self.knowledge_sides = knowledge_sides
        self.roll_type = roll_type

        self.instinct = discord.ui.TextInput(label="Instinct", placeholder="Enter the number of dice to roll for instinct")
        self.knowledge = discord.ui.TextInput(label="Knowledge", placeholder="Enter the number of dice to roll for knowledge")

        self.add_item(self.instinct)
        self.add_item(self.knowledge)

    async def on_submit(self, interaction: discord.Interaction):
        try:
            instinct = int(self.instinct.value)
            knowledge = int(self.knowledge.value)

            instinct_result = roll_asm_dice(instinct, self.instinct_sides)
            knowledge_result = roll_asm_dice(knowledge, self.knowledge_sides)

            user_mention = interaction.user.mention

            await interaction.response.send_message(
                f"🎲 **{user_mention} performed a {self.roll_type} Roll!**\n\n"
                f"🎲 **Instinct Rolls (D{self.instinct_sides}):**\n{instinct_result}\n\n"
                f"🎲 **Knowledge Rolls (D{self.knowledge_sides}):**\n{knowledge_result}"
            )
        except ValueError:
            await interaction.response.send_message("❌ Please enter valid numbers for instinct and knowledge.", ephemeral=True)


@bot.tree.command(name="asm_button", description="Choose between a normal roll or an assimilated roll")
async def asm_roll_button(interaction: discord.Interaction):
    view = discord.ui.View()

    async def open_normal_roll(interaction: discord.Interaction):
        await interaction.response.send_modal(asmModal(6, 10, "Normal")) 

    async def open_assimilated_roll(interaction: discord.Interaction):
        await interaction.response.send_modal(asmModal(12, 12, "Assimilated"))  

    button_normal = discord.ui.Button(label="Normal Roll", style=discord.ButtonStyle.green)
    button_normal.callback = open_normal_roll

    button_assimilated = discord.ui.Button(label="Assimilated Roll", style=discord.ButtonStyle.blurple)
    button_assimilated.callback = open_assimilated_roll

    view.add_item(button_normal)
    view.add_item(button_assimilated)

    await interaction.response.send_message("🎲 Choose between a **Normal Roll** or an **Assimilated Roll**", view=view)


@bot.tree.command(name='asm_roll', description='Rolls instinct and knowledges')
async def asm_roll(interaction:discord.Interaction, instinct:int, knowledges:int):

    await interaction.response.send_message('Rolling instinct and knowledges...')

    instinct_result = roll_asm_dice(instinct, 6)
    knowledges_result = roll_asm_dice(knowledges, 10)

    await interaction.followup.send(f"**Instinct Rolls:**\n{instinct_result}\n\n**knowledges Rolls:**\n{knowledges_result}")

bot.run(DISCORD_TOKEN)
