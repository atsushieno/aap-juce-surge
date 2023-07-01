# aap-juce-surge: port of Surge-XT to AAP

It is an port of [Surge-XT](https://github.com/surge-synthesizer/surge) (and supposedly Surge-FX) to AAP (Audio Plugins For Android) using aap-juce.

surge builds on top of quite complicated software stacks, and there could be various parts that depend on desktop-isms. So far we only verified it loads and generates some audio outputs on aaphostsample and aap-juce-simple-host (it is quite common to AAP ports overall).

Due to build issues on LuaJIT, arm32 and x86 builds are disabled.

## LICENSES

aap-juce-surge is released under the GPL v3 license.

Surge-XT is released under the GPL v3 license.
