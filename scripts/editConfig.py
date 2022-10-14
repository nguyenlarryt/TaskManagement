import sys
import ruamel.yaml

print("Writing to yml...")

yaml = ruamel.yaml.YAML()

with open("build-config.yml") as f:
    y = yaml.safe_load(f)
    y['workflows'][sys.argv[1]]['envs'][0]['MONTHLY_BUILD_NUMBER'] = sys.argv[2]
    print(ruamel.yaml.dump(y))
