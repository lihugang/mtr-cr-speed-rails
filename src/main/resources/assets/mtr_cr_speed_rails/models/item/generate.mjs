import fs from 'fs/promises';

async function write(speed) {
	return Promise.all([
		fs.writeFile(`rail_connector_${speed}.json`, JSON.stringify({
			"parent": "item/generated",
			"textures": {
				"layer0": `mtr_cr_speed_rails:item/rail_connector_${speed}`
			},
			"overrides": [
				{
					"predicate": {
						"mtr:selected": 1
					},
					"model": `mtr_cr_speed_rails:item/rail_connector_${speed}_selected`
				}
			]
		}, null, 4)),
		fs.writeFile(`rail_connector_${speed}_oneway.json`, JSON.stringify({
			"parent": "item/generated",
			"textures": {
				"layer0": `mtr_cr_speed_rails:item/rail_connector_${speed}_oneway`
			},
			"overrides": [
				{
					"predicate": {
						"mtr:selected": 1
					},
					"model": `mtr_cr_speed_rails:item/rail_connector_${speed}_oneway_selected`
				}
			]
		}, null, 4)),
		fs.writeFile(`rail_connector_${speed}_selected.json`, JSON.stringify({
			"parent": "item/generated",
			"textures": {
				"layer0": `mtr_cr_speed_rails:item/rail_connector_${speed}`,
				"layer1": "mtr:item/rail_connector_selected"
			}
		}, null, 4)),
		fs.writeFile(`rail_connector_${speed}_oneway_selected.json`, JSON.stringify({
			"parent": "item/generated",
			"textures": {
				"layer0": `mtr_cr_speed_rails:item/rail_connector_${speed}_oneway`,
				"layer1": "mtr:item/rail_connector_selected"
			}
		}, null, 4))]);
}

const speeds = [100, 140, 170, 220, 250, 260, 275, 290, 310, 350, 355, 380, 400, 420, 450, 486, 500];
speeds.forEach(speed => write(speed));
