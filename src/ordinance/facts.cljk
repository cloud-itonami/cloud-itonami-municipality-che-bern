(ns ordinance.facts
  "Municipal-ordinance compliance catalog for Bern -- the FORTY-SECOND
  municipality-level entry (see cloud-itonami-municipality-jpn-tokyo,
  -usa-washington-dc, -gbr-london, -can-toronto, -deu-berlin, -fra-paris,
  -nld-amsterdam, -esp-madrid, -kor-seoul, -ita-roma, -aus-sydney,
  -arg-buenos-aires, -fin-helsinki, -dnk-copenhagen, -nor-oslo,
  -bel-brussels, -chl-santiago, -col-bogota, -cri-san-jose,
  -bra-sao-paulo, -ury-montevideo, -zaf-cape-town, -ecu-quito,
  -swe-gothenburg, -pry-asuncion, -mex-guadalajara, -fra-lyon,
  -ind-new-delhi, -pol-warsaw, -ken-nairobi, -tha-bangkok, -are-abu-dhabi,
  -vnm-hanoi, -idn-jakarta, -phl-manila, -egy-cairo, -tur-ankara,
  -nga-abuja, -sau-riyadh, -mys-kuala-lumpur, -aut-vienna for the first
  forty-one) per ADR-2607141700 (cloud-itonami-compliance-fact-federation).
  Switzerland's first entry across any of the 3 axes.

  Switzerland has NO de jure capital designation in its Federal
  Constitution -- unlike every other municipality in this catalog.
  Bern serves as the de facto seat of federal government
  ('Bundesstadt', federal city) since a Federal Assembly vote on 28
  November 1848 (formally confirmed 27 December 1848), per the Swiss
  National Museum's own historical blog. This is a stable,
  well-understood constitutional arrangement -- not an ongoing
  ambiguity like Egypt/Indonesia checked earlier this session --
  documented transparently here rather than glossing over the
  constitutional silence.

  Gemeindeordnung der Stadt Bern (GO, Bern's municipal charter, SSSB
  101.1) -- title and 3 December 1998 date directly confirmed: the
  Bauordnung der Stadt Bern's own preamble (see below) cites it
  verbatim as 'Artikel 36 Buchstabe c der Gemeindeordnung der Stadt
  Bern vom 3. Dezember 1998'.

  Bauordnung der Stadt Bern (BO, Bern's building code, SSSB 721.1) --
  directly confirmed by reading the official document text via the
  Read-tool saved-path fallback (WebFetch itself reported the PDF as
  illegible/binary), whose own header states '24. September 2006
  (Stand: 1. Oktober 2020)' immediately above the title 'Bauordnung
  der Stadt Bern (BO)'.

  stadtrecht.bern.ch (Bern's own legal-database portal) rendered as a
  bare heading with no body content via WebFetch (likely a JS-rendered
  single-page app), and ris.bern.ch returned a connection refusal --
  both abandoned in favor of the be.ch OEREB-hosted PDF mirror, which
  rendered legibly.

  An ordinance not in this table has NO spec-basis, full stop; extend
  `catalog`, do not invent an id/url/date.")

(def catalog
  "municipality-slug -> vector of ordinance entries."
  {"bern"
   [{:ordinance/id "bern.go-1998-gemeindeordnung"
     :ordinance/title "Gemeindeordnung der Stadt Bern (GO)"
     :ordinance/municipality "bern"
     :ordinance/country "CHE"
     :ordinance/kind :local-act
     :ordinance/number "SSSB 101.1"
     :ordinance/url "https://oerebfiles.apps.be.ch/35101/3061/Bern_SSSB_721_1_Bauordnung_der_Stadt_Bern.pdf"
     :ordinance/url-provenance :official-be-ch-oereb-mirror
     :ordinance/enacted-date "1998-12-03"
     :ordinance/retrieved-at "2026-07-17"
     :ordinance/topic #{:governance}}
    {:ordinance/id "bern.bo-2006-bauordnung"
     :ordinance/title "Bauordnung der Stadt Bern (BO)"
     :ordinance/municipality "bern"
     :ordinance/country "CHE"
     :ordinance/kind :local-act
     :ordinance/number "SSSB 721.1"
     :ordinance/url "https://oerebfiles.apps.be.ch/35101/3061/Bern_SSSB_721_1_Bauordnung_der_Stadt_Bern.pdf"
     :ordinance/url-provenance :official-be-ch-oereb-mirror
     :ordinance/enacted-date "2006-09-24"
     :ordinance/retrieved-at "2026-07-17"
     :ordinance/topic #{:construction}}]})

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
      :note (str "cloud-itonami-municipality-che-bern Wave 0 (ADR-2607141700): "
                 (count (get catalog "bern")) " Bern entries seeded "
                 "with be.ch OEREB-mirror citations. "
                 "Extend `ordinance.facts/catalog`, never fabricate an id/url.")})))

(defn by-topic [muni topic]
  (filterv #(contains? (:ordinance/topic %) topic) (spec-basis muni)))
