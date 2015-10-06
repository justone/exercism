(ns meetup
  (:import [java.util Calendar GregorianCalendar]))

; java constant to day of week keyword, one based so first element is just placeholder
(def days [:none :sunday :monday :tuesday :wednesday :thursday :friday :saturday])

; how to select the particular day from all the similar days in a month. i.e.
; how to pick the specific thursday out of all the thursdays in the month
(def type->filter {
                   :teenth (fn [in] (some #(< 12 (:day %) 20) in))
                   :last last
                   :first first
                   :second second
                   :third #(nth % 2)
                   :fourth #(nth % 3)
                   })

(defn monthseq
  "Generate a list of tuples ({:day-of-week :monday :day 1} {:day-of-week :tuesday :day 2} ...) for a given month"
  [month year]
  (let [cal (doto (GregorianCalendar.) (.set year (dec month) 1))
        last-day (.getActualMaximum cal Calendar/DAY_OF_MONTH)]
    (->> (range 1 (inc last-day))
         (map #(doto (GregorianCalendar.) (.set year (dec month) %)))
         (map #(hash-map :day-of-week (days (.get % Calendar/DAY_OF_WEEK)) :day (.get % Calendar/DAY_OF_MONTH))))))

(defn meetup
  [month year day-of-week type]
  (let [mseq (monthseq month year)                            ; all the days in the month
        dows (filter #(= (:day-of-week %) day-of-week) mseq)  ; just those that match the day-of-week argument
        meetup-day ((type->filter type) dows)]                ; grab appropriate day based on above fns
    [year month (:day meetup-day)]))
