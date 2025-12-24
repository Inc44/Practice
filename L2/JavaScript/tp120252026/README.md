```bash
curl https://linkxp.lexprod.net/ > index.html
mkdir module_assets
curl https://linkxp.lexprod.net/hubfs/hub_generated/template_assets/1/183393234599/1740625487033/template_framework-style-main.min.css > module_assets/template_framework-style-main.min.css
curl https://linkxp.lexprod.net/hubfs/hub_generated/module_assets/1/183393234728/1740802036472/module_Back_to_Top.min.css > module_assets/module_Back_to_Top.min.css
curl https://linkxp.lexprod.net/hubfs/hub_generated/module_assets/1/183393234724/1740802030932/module_Progress_Bar.min.css > module_assets/module_Progress_Bar.min.css
curl https://linkxp.lexprod.net/hubfs/hub_generated/module_assets/1/183393000544/1740802019913/module_Hero_-_Two_Column.min.css> module_assets/module_Hero_-_Two_Column.min.css
curl https://linkxp.lexprod.net/hubfs/hub_generated/module_assets/1/183393000545/1740802021544/module_Counter.min.css > module_assets/module_Counter.min.css
curl https://linkxp.lexprod.net/hubfs/hub_generated/module_assets/1/183392997404/1740802009777/module_2_Col_Text_and_Image.min.css > module_assets/module_2_Col_Text_and_Image.min.css
curl https://linkxp.lexprod.net/hubfs/hub_generated/module_assets/1/183392997405/1740802011065/module_Feature_Cards.min.css > module_assets/module_Feature_Cards.min.css
curl https://7052064.fs1.hubspotusercontent-na1.net/hubfs/7052064/hub_generated/module_assets/1/-53649664089/1766173979161/module_payments.min.css > module_assets/module_payments.min.css
curl https://linkxp.lexprod.net/hubfs/hub_generated/module_assets/1/183393234725/1740802032579/module_Theme_Rich_Text.min.css > module_assets/module_Theme_Rich_Text.min.css
curl https://linkxp.lexprod.net/hubfs/hub_generated/module_assets/1/183393000541/1740802017402/module_Testimonials_Slider.min.css > module_assets/module_Testimonials_Slider.min.css
curl https://linkxp.lexprod.net/hubfs/hub_generated/template_assets/1/183392997283/1740625494548/template_framework-script.min.js > module_assets/template_framework-script.min.js
curl https://linkxp.lexprod.net/hubfs/hub_generated/module_assets/1/183393234728/1740802036472/module_Back_to_Top.min.js > module_assets/module_Back_to_Top.min.js
curl https://linkxp.lexprod.net/hubfs/hub_generated/module_assets/1/183393234724/1740802030932/module_Progress_Bar.min.js > module_assets/module_Progress_Bar.min.js
curl https://linkxp.lexprod.net/hubfs/hub_generated/module_assets/1/183393000545/1740802021544/module_Counter.min.js > module_assets/module_Counter.min.js
touch styles.css
```

Format with Fortify Formatter after every step below:

Move content of `<style>` tags to styles.css and remove `<style>` tags

Add `@import url('https://fonts.googleapis.com/css2?family=Archivo:ital,wght@0,100..900;1,100..900&display=swap');` to top of `styles.css`

Remove from `styles.css`:
- `@font-face\n\{[\s\S]*?\}\n`
- `/\*.*\*/`

Add `<link rel="stylesheet" href="styles.css">` to `<head>` after last `<link>` tag

Replace:
- `doctype` with `DOCTYPE`
- `fr-fr` with `fr`
- `utf` with `UTF`
- `initial-scale=1` with `initial-scale=1.0`
- `<link rel="stylesheet" href=".*/(.*).css">` with `<link rel="stylesheet" href="module_assets/$1.css">`
- `<script src=".*/(.*).js">` with `<script src="module_assets/$1.js">`
- `src="https://linkxp.lexprod.net/hs-fs/hubfs/logo---transparent-250x95.png.*?"` with `src="../tp120252026/images/logo---transparent-250x95.png"`
- `srcset="https://linkxp.lexprod.net/hs-fs/hubfs/logo---transparent-250x95.png.*?"` with `srcset="../tp120252026/images/logo---transparent-250x95.png"`
- `src="https://linkxp.lexprod.net/hs-fs/hubfs/linkxp-bg-transparent-2.png\?width=150.*?"` with `src="../tp120252026/images/linkxp-bg-transparent-2_5.png"`
- `srcset=".*?https://linkxp.lexprod.net/hs-fs/hubfs/linkxp-bg-transparent-2.png\?width=150.*?"` with `srcset="../tp120252026/images/linkxp-bg-transparent-2_5.png"`
- `src="https://linkxp.lexprod.net/hs-fs/hubfs/linkxp-bg-transparent-2.png.*?"` with `src="../tp120252026/images/linkxp-bg-transparent-2_11.png"`
- `srcset="https://linkxp.lexprod.net/hs-fs/hubfs/linkxp-bg-transparent-2.png.*?"` with `srcset="../tp120252026/images/linkxp-bg-transparent-2_11.png"`
- `src="https://linkxp.lexprod.net/hubfs.*/(.*?")` with `src="../tp120252026/images/$1`
- `<span id="hs_cos_wrapper_widget_[0-9]{13}_" class="hs_cos_wrapper hs_cos_wrapper_widget .*?">\n\t*(.*)\n\t*</span>` with `$1`
- `(h[0-9]>) ` with `$1`
- ` (</h[0-9])` with `$1`
- `span> ` with `span>`
- `\n\t*</div>` with `</div>`
- `\n\t*</span>` with `</span>`
- `’` with `'`
- ` ` with ` `

Remove:
- `<!--.*-->`
- `<script.*src=".*/embed.js"></script>`
- `<script.*src=".*/project.js"></script>`
- `<script.*src=".*/module_Hero_-_Two_Column.min.js"></script>`
- `<script.*src=".*/module_Feature_Cards.min.js"></script>`
- `<script.*src=".*/PaymentsEmbedCode.js"></script>`
- `<script.*src=".*/module_Logos.min.js"></script>`
- `<script.*src=".*/module_Testimonials_Slider.min.js"></script>`
- `<script.*src=".*/48297605.js"></script>`
- `<script.*src=".*/index.js"></script>`
- `<script>[\s\S]*?</script>\n` except `<script>window.themeVars = {headerHeight: 100};</script>`
- `<script type="text/javascript">[\s\S]*?</script>\n`
- `<meta.*>` except `<meta charset="UTF-8">` and `<meta name="viewport" content="width=device-width, initial-scale=1.0">`
- `<noscript.*>`
- `<link rel="canonical" href="https://linkxp.lexprod.net">`
- `<p></p>`
- `http://lexprod.net`
- `https://linkxp.lexprod.net/démonstration-de-la-plateforme-linkxp`
- `https://www.linkedin.com/company/68232378/`
- `data-.*?=".*?"` except `data-purecounter-.*?=".*?"`
- `class="no-js"`
- `style=""`
- `loading="lazy"`
- `row-depth-1`
- `row-number-[0-9]{1,2}`
- `site-header--not-scrolled`
- `widget-type-cell`
- `header-row-0-background-color`
- `dnd-row`
- `widget-type-custom_widget`
- `cell_17356528447512-row-2-vertical-alignment`
- `class="\s*hs-.*?"`
- `hs-search-hidden`
- `id="hs-.*?"`
- `<div style="display: none;">[\s\S]*?^\s*</div>\n`
- `<div class=".*main_content-row-[0-9]-hidden.*">[\s\S]*?^\s{6}</div>\n`


Replace:
- `  ` with ` `
- `  ` with ` `
- ` "` with `"`
- `=" ` with `="`


Remove:
- `class=""`


Replace:
- `<span id="hs_cos_wrapper_site-footer-module-[0-9]{1,2}_" class="hs_cos_wrapper hs_cos_wrapper_widget hs_cos_wrapper_type_rich_text">([\s\S]*?)^\s*</span></div>\n` with `$1</div>`