# Team Specification

> Last Updated: 2026-06-30

This document defines the team system of EconomiCraft.

---

# Philosophy

The team system is inspired by Hypixel SkyBlock Coop mechanics while remaining flexible for survival and multiplayer environments.

Design goals:

- Shared progression
- Independent personal ownership
- Strong multiplayer support
- Configurable scalability
- Future expansion compatibility

---

# Team Structure

```text
Team

├── Owner
├── Manager
└── Member
```

Default maximum members:

```properties
team.max_members=8
```

Special value:

```properties
-1 = Unlimited
```

Reference:

```text
Hypixel SkyBlock Party:
Maximum Members = 5
```

---

# Permissions

## Owner

Permissions:

```text
Invite Players

Kick Players

Promote Members

Demote Managers

Rename Team

Delete Team

Change Team Color

Edit MOTD

Edit Description

Access Team Bank

View Team Logs
```

---

## Manager

Permissions:

```text
Invite Players

Edit MOTD

Access Team Bank

View Team Logs
```

---

## Member

Permissions:

```text
Deposit Team Bank

Use Team Chat

View Team Information

View Team Members
```

---

# Bank System

Players always retain their personal bank.

```text
Personal Bank
└── Independent

Team Bank
└── Shared
```

Both systems operate independently.

---

# Team Bank Interest

Interest is applied every three Minecraft days.

```text
Interval:
3 Minecraft Days
```

Supported modes:

```text
standard

small_server

custom
```

---

## Standard Mode

```text
Base:
3%

Additional Member:
+1%
```

Example:

```text
1 Member = 3%
2 Members = 4%
3 Members = 5%
4 Members = 6%
```

---

## Small Server Mode

```text
Base:
3%

Additional Member:
+3%
```

Example:

```text
1 Member = 3%
2 Members = 6%
3 Members = 9%
4 Members = 12%
```

---

# Team Deletion

Deletion process:

```text
Delete Team
        ↓
Transfer Team Bank
        ↓
Owner Personal Bank
        ↓
Create Transaction Log
        ↓
Delete Team
```

Example:

```text
[TEAM_DELETE]

Team:
Builders

Transferred:
1,250,000 COIN

Receiver:
LunaMist3941
```

The transaction must always be logged.

---

# Team Chat

EconomiCraft uses the standard Minecraft chat system.

---

## Temporary Messages

```text
/tc Hello everyone!

/teamchat Hello everyone!
```

After sending a message, the player returns to normal chat mode.

---

## Persistent Team Chat

Enable:

```text
/tc on
```

Disable:

```text
/tc off
```

Status:

```text
/tc status
```

Example:

```text
Hello
↓
[TEAM] Hello
```

---

## Configuration

```properties
team.chat.enabled=true

team.chat.persistent_mode=true

team.chat.history.enabled=true

team.chat.max_entries=5000
```

---

# Team Members Command

Official command:

```text
/team members
```

Short alias:

```text
/tm
```

The command displays both online and offline members.

Example:

```text
Team:
Builders

Online (3/8)

● LunaMist3941
● Steve
● Alex

Offline

○ Builder01
○ Builder02
```

All team roles may use this command.

---

# Team Information Command

Command:

```text
/team info
```

Example output:

```text
Team:
Builders

Color:
Green

Owner:
LunaMist3941

Members:
5/8

Online:
3

MOTD:
Next Project: Central Market

Bank:
1,250,000 COIN
```

---

# Team MOTD

Structure:

```text
Team

├── Name
├── Color
├── MOTD
└── Description
```

Example:

```text
Team:
Builders

MOTD:
Next Project: Central Market

Description:
We build cities and infrastructure.
```

---

## Display Timing

The MOTD is displayed when:

```text
Player Login

Joining A Team

/team info
```

The message should not appear during every chat interaction.

---

## Configuration

```properties
team.motd.enabled=true

team.motd.max_length=128

team.description.enabled=true

team.description.max_length=512
```

---

# Team Color

EconomiCraft uses team tags instead of modifying player names.

Example:

```text
[Builders] LunaMist3941:
Hello
```

---

## Name Tag

```text
[Builders]
LunaMist3941
```

---

## Player List

```text
[Builders] LunaMist3941
```

---

## Configuration

```properties
team.default_color=GREEN

team.allow_custom_colors=true
```

---

## Allowed Colors

```text
WHITE

GRAY

GREEN

BLUE

AQUA

GOLD

YELLOW

RED

LIGHT_PURPLE
```

---

# GUI System

The team interface uses a 54-slot chest menu.

---

# Main Team Menu

```text
Team

├── Team Information
├── Team Members
├── Team Bank
├── Team MOTD
├── Team Settings
└── Back
```

---

# Team Members Menu

Both online and offline members are displayed.

Example:

```text
👑 LunaMist3941 (Owner)

⭐ Steve (Manager)

👤 Alex (Member)

○ Builder01 (Offline)

○ Builder02 (Offline)
```

---

## Recommended Icons

```text
Owner:
Nether Star

Manager:
Gold Ingot

Member:
Player Head
```

---

# Team Information Menu

Example:

```text
Name:
Builders

Color:
Green

Members:
5/8

Online:
3

MOTD:
Next Project:
Central Market

Description:
We build cities.
```

---

# Team Settings Menu

## Owner

```text
Rename Team

Change Team Color

Edit MOTD

Edit Description

Permissions

Invite Players

Delete Team
```

---

## Manager

```text
Edit MOTD

Invite Players

Permissions
```

---

## Member

```text
View Information

Leave Team
```

---

# Team Logs

Supported log entries:

```text
Deposit

Withdraw

Interest

Join

Leave

Kick

Promotion

Rename

Delete Team
```

---

## Configuration

```properties
team.log.max_entries=1000
```

---

# Commands

```text
/team create <name>

/team invite <player>

/team accept

/team leave

/team kick <player>

/team promote <player>

/team demote <player>

/team rename <name>

/team delete

/team info

/team members

/tm

/tc <message>

/tc on

/tc off

/tc status
```

---

# Future Projects

The following features belong to a separate project.

```text
EconomiCraft TeamPlus

├── Team Home
├── Team Warp
├── Team Claims
├── Team Quests
└── Team Achievements
```

These features are not part of the core Team system.

---

# Final Principle

> Teams should encourage cooperation without sacrificing individual ownership and progression.