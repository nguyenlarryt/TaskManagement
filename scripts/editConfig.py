import yaml

print("Writing to yml...")
with open("../build-config.yml") as f:
    y = yaml.safe_load(f)
    y['workflows'][sys.argv[1]]['envs']['MONTHLY_BUILD_NUMBER'] = sys.arv[2]
    print(yaml.dump(y, default_flow_style=False, sort_keys=False))
