(ns culture.facts
  "Regional-culture catalog for Bern -- local dishes,
  protected products, beverages, festivals and heritage sites, piggybacked
  onto this municipality compliance repo per ADR-2607171400
  (cloud-itonami-municipality-culture-catalog, in com-junkawasaki/root),
  sibling namespace to `ordinance.facts` (ADR-2607141700).

  Every entry cites a source URL that was actually fetched and read on
  :culture/retrieved-at -- never fabricated. Summaries state only what the
  cited source confirms. An item not in this table has NO spec-basis, full
  stop; extend `catalog`, do not invent an id/url.")

(def catalog
  "municipality-slug -> vector of culture entries."
  {"bern"
   [{:culture/id "bern.dish.roesti"
     :culture/name "Rösti"
     :culture/municipality "bern"
     :culture/country "CHE"
     :culture/kind :dish
     :culture/summary "Swiss dish of sautéed or shallow-fried potatoes that originated in the canton of Bern, where it was originally a breakfast dish commonly eaten by farmers."
     :culture/url "https://en.wikipedia.org/wiki/R%C3%B6sti"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "bern.dish.berner-platte"
     :culture/name "Berner Platte"
     :culture/municipality "bern"
     :culture/country "CHE"
     :culture/kind :dish
     :culture/summary "Traditional meat dish of Bernese cuisine in Switzerland, originating from the canton of Bern and named after the Bernese."
     :culture/url "https://en.wikipedia.org/wiki/Berner_Platte"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "bern.dish.fondue"
     :culture/name "Fondue"
     :culture/municipality "bern"
     :culture/country "CHE"
     :culture/kind :dish
     :culture/summary "Melted-cheese dish promoted as a Swiss national dish by the Swiss Cheese Union in the 1930s; national rather than Bern-specific."
     :culture/url "https://en.wikipedia.org/wiki/Fondue"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "bern.product.emmental-cheese"
     :culture/name "Emmental cheese"
     :culture/name-local "Emmentaler"
     :culture/municipality "bern"
     :culture/country "CHE"
     :culture/kind :product
     :culture/summary "Hard yellow cheese originating from the Emme Valley in Switzerland, with Swiss AOP certification (2013); production regulations name the canton of Bern among the permitted cantons."
     :culture/url "https://en.wikipedia.org/wiki/Emmental_cheese"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "bern.product.toblerone"
     :culture/name "Toblerone"
     :culture/municipality "bern"
     :culture/country "CHE"
     :culture/kind :product
     :culture/summary "Chocolate bar created by the Tobler chocolate factory founded in Bern in 1899 and produced exclusively in Bern until 2022."
     :culture/url "https://en.wikipedia.org/wiki/Toblerone"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "bern.festival.zibelemaerit"
     :culture/name "Zibelemärit"
     :culture/municipality "bern"
     :culture/country "CHE"
     :culture/kind :festival
     :culture/summary "Traditional onion market held in Bern on the fourth Monday in November, featuring onion-based foods such as onion pie."
     :culture/url "https://en.wikipedia.org/wiki/Zibelem%C3%A4rit"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "bern.heritage.old-city-of-bern"
     :culture/name "Old City of Bern"
     :culture/municipality "bern"
     :culture/country "CHE"
     :culture/kind :heritage
     :culture/summary "Medieval city centre of Bern, a UNESCO Cultural World Heritage Site since 1983 for its compact and generally intact medieval core."
     :culture/url "https://en.wikipedia.org/wiki/Old_City_of_Bern"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "bern.heritage.zytglogge"
     :culture/name "Zytglogge"
     :culture/municipality "bern"
     :culture/country "CHE"
     :culture/kind :heritage
     :culture/summary "Landmark medieval tower in Bern built around 1218-1220, famous for its 15th-century astronomical clock."
     :culture/url "https://en.wikipedia.org/wiki/Zytglogge"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}]})

(defn spec-basis [muni] (get catalog muni))

(defn coverage
  ([] (coverage (keys catalog)))
  ([munis]
   (let [have (filter catalog munis)
         missing (remove catalog munis)]
     {:requested (count munis)
      :covered (count have)
      :covered-municipalities (vec (sort have))
      :missing-municipalities (vec (sort missing))
      :note (str "cloud-itonami-municipality-che-bern culture catalog "
                 "(ADR-2607171400): " (count (get catalog "bern"))
                 " Bern entries, each with a fetched-and-read citation. "
                 "Extend `culture.facts/catalog`, never fabricate an id/url.")})))

(defn by-kind [muni kind]
  (filterv #(= (:culture/kind %) kind) (spec-basis muni)))
