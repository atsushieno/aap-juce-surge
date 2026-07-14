# aap-juce-surge: port of Surge-XT to AAP

It is a port of [Surge XT](https://github.com/surge-synthesizer/surge) to [Audio Plugins For Android (AAP)](https://github.com/atsushieno/aap-core), using [aap-juce](https://github.com/atsushieno/aap-juce).

surge builds on top of quite complicated software stacks, and there could be various parts that depend on desktop-isms, even after the patches we applied to surge.

We still haven't ported Surge FX for kind of silly reason - building Surge XT is already too big and memory-consuming work. Building another one will run out of Java heap space (we can build separately but it is complicating build structure...)

## LICENSES

aap-juce-surge is released under the GPL v3 license.

Surge-XT is released under the GPL v3 license.
