
(defn wrapper [text limit]
  (def words (clojure.string/split text #" "))
  (def result (first words))
  (def space-left (- limit (count result)))
  (def result-arr ())

;;   FIXME: Does not return value from the map
;;   (apply merge
;;          map (fn [word]
;;                (if (<= space-left (count word))
;;                  (do
;;                    (def result (str result "\n" word))
;;                    (def space-left (- limit (count word)))
;;                    (result)


;;                    (do
;;                      (def result (str result " " word))
;;                      (def space-left (- space-left (count word) 1))))))
;;          rest words))

  (for [word (rest words)]
    (if (<= space-left (count word))
      (do
        (def result (str result "\n" word))
        (def space-left (- limit (count word)))
        ;; FIXME: result is available only in for scope and does not overwrite global result
        (println result))

      (do
        (def result (str result " " word))
        (def space-left (- space-left (count word) 1))))))

(wrapper "Forty-one Discworld novels have been published. Apart from the first novel in the series, The Colour of Magic, the original British editions of the first 26 novels, up to Thief of Time (2001), had cover art by Josh Kirby. After Kirby's death in 2001, the covers were designed by Paul Kidby. The American editions, published by HarperCollins, used their own cover art. Companion publications include eleven short stories (some only loosely related to the Discworld), four popular science books, and a number of supplementary books and reference guides. The series has been adapted for graphic novels, theatre, computer and board games, and television." 40)

