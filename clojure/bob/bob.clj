(ns bob
  (:require [clojure.string :as str]))

(defn response-for
  [statement]
  (let [nothing? #(empty? (str/trim %))
        yelling? #(and (re-matches #".*[A-Z].*" %1) (= (str/upper-case %1) %1))
        question? #(re-matches #".*\?$" %)]
    (cond
      (nothing? statement)  "Fine. Be that way!"
      (yelling? statement)  "Whoa, chill out!"
      (question? statement) "Sure."
      :else "Whatever.")))

; Tried, and failed with regexes...
;
; (defn response-for
;   [statement]
;   (condp re-matches statement
;     #"^\s*$"   "Fine. Be that way!"
;     #".*[a-z0-9]+\?$"   "Sure."
;     #"[A-Z !123?]+" "Whoa, chill out!"
;     "Whatever."))
