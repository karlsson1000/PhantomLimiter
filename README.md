# PhantomLimiter

PhantomLimiter lets you control how often phantoms spawn, whether you want peaceful nights or no phantoms at all, the choice is yours.

In vanilla Minecraft, the longer you don't sleep, the higher the chance phantoms will spawn, about 25% after 4 days and around 40% by day 5.
With PhantomLimiter, you set a fixed spawn rate that replaces the vanilla system entirely.

**Example:**
- In vanilla Minecraft on day 5, phantoms might have a 40% chance to spawn.
- With PhantomLimiter set to 25% (default), phantoms will have exactly 25% chance to spawn when vanilla tries to spawn them, regardless of how long players haven't slept.
- Setting it to 10% means only 1 in 10 vanilla phantom spawn attempts will succeed.
  
## Features
- Lightweight and performant, minimal server impact.
- Adjustable spawn rate via config (phantom-spawn-rate).
- Simple reload command: /phantomlimiter reload

## Installation
1. Download the latest release from the [PhantomLimiter Modrinth project page](https://modrinth.com/plugin/phantomlimiter).
2. Place the `PhantomLimiter.jar` file into your server’s `plugins` folder.
3. Restart your server.

## Commands and Permissions
| Command              | Description                         | Permission              | Usage                        |
|----------------------|-------------------------------------|-------------------------|------------------------------|
| /phantomlimiter reload | Reloads the PhantomLimiter config. | `phantomlimiter.reload` | `/phantomlimiter reload`     |
