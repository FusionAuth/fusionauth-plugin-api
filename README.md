# FusionAuth Plugin API ![semver 2.0.0 compliant](http://img.shields.io/badge/semver-2.0.0-brightgreen.svg?style=flat-square)

This project provides the APIs and SPIs that are used to write FusionAuth plugins.

Currently, there is a single plugin SPI for FusionAuth that allows customers to support different password encryption schemes. This interface is `io.fusionauth.plugin.spi.security.PasswordEncryptor`.

You can learn more about FusionAuth plugins by visiting our documentation page at [https://fusionauth.io/docs/v1/tech/plugins/writing-a-plugin](https://fusionauth.io/docs/v1/tech/plugins/writing-a-plugin).


## Building

The build uses Gradle and Java 25 from [mise](https://mise.jdx.dev/); the jar itself targets Java 8.

```bash
$ mise install
$ gradle build
```

To install the jar into your local Maven repository (`~/.m2`):

```bash
$ gradle publishToMavenLocal
```

### Releasing

Releases must be signed. Add the key to your own `~/.gradle/gradle.properties` (never to this repository):

```properties
signing.gnupg.keyName=<gpg key fingerprint>
```

The version comes from the git tag on the current commit (for example `1.67.0`); untagged commits build a `-SNAPSHOT`
version. Use the task for the repository you want; plain `gradle publish` is blocked so that one command never uploads to
every repository at once.

#### Maven Central

Releases go through the Sonatype Central Portal. Also add your Central Portal user token to `~/.gradle/gradle.properties`:

```properties
mavenCentralUsername=<Central Portal user token name>
mavenCentralPassword=<Central Portal user token password>
```

```bash
$ gradle publishToMavenCentral
```

#### Private repository (CodeArtifact)

Set the repository URL with the `codeArtifactUrl` Gradle property (for example in `~/.gradle/gradle.properties`) or the
`CODEARTIFACT_URL` environment variable. The auth token is fetched automatically (see `gradle/codeArtifactTokenFetcher.groovy`).

```bash
$ gradle publishAllPublicationsToCodeArtifactRepository
```
