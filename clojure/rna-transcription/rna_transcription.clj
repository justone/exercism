(ns rna-transcription
  (:require [clojure.string :refer [join]])
  (:require [clojure.walk :refer [walk]]))

(def mapping (apply hash-map "GCCGTAAU"))

(defn transcribe [what]
  (or (get mapping what) (assert false)))

(defn to-rna [what]
    (walk transcribe join (seq what)))
