# PhantomLimiter

![Modrinth](https://img.shields.io/modrinth/v/d5YylCDk)

PhantomLimiter lets you control how often phantoms spawn, whether you want peaceful nights or no phantoms at all, the choice is yours.

In vanilla Minecraft, the longer you don't sleep, the higher the chance phantoms will spawn, about 25% after 4 days and around 40% by day 5. PhantomLimiter filters vanilla phantom spawns, reducing them by your chosen spawn rate.

**Example:**
- In vanilla Minecraft on day 5, phantoms might have a 40% chance to spawn.
- With PhantomLimiter set to 25% (default), only 25% of vanilla phantom spawn attempts will succeed, regardless of how long players haven't slept.
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

---

![PhantomLimiter](https://cdn.modrinth.com/data/d5YylCDk/images/7edff8838cb454de5ff6b0d0e071071c8cf5ed32.png)
